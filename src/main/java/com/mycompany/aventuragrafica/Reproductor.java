package com.mycompany.aventuragrafica;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class Reproductor {
    
    private static MP3Player player;
    private static Thread hiloBucle;
    private static boolean enBucle = false;

    public static void reproducir(String rutaMp3) {
        if (player != null && !player.isStopped()) {
            player.stop();
        }
        pararBucle();
        
        player = new MP3Player(new File(rutaMp3));
        player.play();
    }

    public static void reproducirBucle(String rutaMp3) {
        reproducirBucle(rutaMp3, -1);
    }

    public static void reproducirBucle(String rutaMp3, int repeticiones) {
        if (hiloBucle != null && hiloBucle.isAlive()) {
            pararBucle();
        }
        
        enBucle = true;
        hiloBucle = new Thread(() -> {
            int conteo = 0;
            while (enBucle && (repeticiones == -1 || conteo < repeticiones)) {
                if (player != null && !player.isStopped()) {
                    player.stop();
                }
                
                player = new MP3Player(new File(rutaMp3));
                player.play();
                
                try {
                    Thread.sleep(100);
                    while (enBucle && player != null && !player.isStopped()) {
                        Thread.sleep(500);
                    }
                    conteo++;
                } catch (InterruptedException e) {
                    enBucle = false;
                    break;
                }
            }
            enBucle = false;
        });
        hiloBucle.start();
    }

    public static void parar() {
        pararBucle();
        if (player != null && !player.isStopped()) {
            player.stop();
        }
    }

    private static void pararBucle() {
        enBucle = false;
        if (hiloBucle != null && hiloBucle.isAlive()) {
            hiloBucle.interrupt();
        }
    }
}