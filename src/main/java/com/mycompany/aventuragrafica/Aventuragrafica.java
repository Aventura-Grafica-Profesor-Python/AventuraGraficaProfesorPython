package com.mycompany.aventuragrafica;

import modulos.*;

public class Aventuragrafica {

    // ===== VARIABLES GLOBALES =====
    static int dinero = 0;
    static boolean pergamino1 = false;
    static boolean pergamino2 = false;
    static boolean pergamino3 = false;
    static boolean hablarSeñor = false;
    static boolean colarseAtrasTienda = false;
    static String nombreHombre;
    static String nombreMujer;
    static String nombreJug;
    static String[] nombres = { "Ana", "Bruno", "Carla", "Diego" };
    static int[] tiempos = { 1, 2, 5, 10 };
    static boolean[] ladoInicial = { true, true, true, true }; // true = lado inicial
    static int tiempoTotal = 0;
    static boolean linternaLadoInicial = true;
    static boolean subirArbol = false;
    static boolean permisoHomer = false;
    static boolean llaveRio = false;
    static boolean verAcertijo2 = false;
    static String[] letras = { "A", "B", "C", "D", "E" };
    static int[] librosPosibles = { 3, 5, 7, 9, 11 };
    static int[] solucionReal = { 11, 3, 5, 7, 9 }; // A,B,C,D,E

// asignacion[i] = número de libros que el jugador le pone a la letra i
// por defecto 0 = sin asignar
    static int[] asignacion = { 0, 0, 0, 0, 0 };

    // ===== MAIN =====
    public static void main(String[] args) {
        inicio();
        presentacionJuego();
        datosPersonajes();
        inicioJuego();
        FuncionesGraficas.warning("Fin del juego", "Has terminado el juego, enhorabuena " + nombreJug);
    }

    // ===== INICIO GENERAL =====
    static void inicio() {
        Reproductor.parar();
        FuncionesGraficas.FotoMensajeSonidoAutomatica(
                "Comienzo del juego",
                "src/main/java/resources/Imagenes/inicio_del_juego/VideoEntrada.gif",
                "En una ciudad, de la nada ocurrio lo inesperado",
                "src/main/java/resources/Sonidos/AudioVideo.wav",
                17,
                1,
                0,
                true
        );

        nombreJug = FuncionesGraficas.pedirDatos(
                "Bienvenido",
                "¿Cuál es tu nickname?");
    }

    static void presentacionJuego() {
        Reproductor.parar();
        Reproductor.reproducirBucle("src/main/java/resources/Sonidos/Layton1.mp3");

        FuncionesGraficas.FotoyMensaje(
                "Portada",
                "src/main/java/resources/imagenes/inicio_general/PORTADA IMAGEN BUENA.png",
                "El Profesor Python y El Misterio de la Alcantarilla",
                0.4,
                false
        );
    }

    static void datosPersonajes() {
        Reproductor.parar();
        nombreMujer = FuncionesGraficas.FotoYPedirDatos(
                "Personaje 1",
                "src/main/java/resources/imagenes/personajes/chica.png",
                "Nombre de la chica:",
                1.0,
                false
        );

        nombreHombre = FuncionesGraficas.FotoYPedirDatos(
                "Personaje 2",
                "src/main/java/resources/imagenes/personajes/chico.png",
                "Nombre del chico:",
                1.0,
                false
        );
    }

    // ===== INICIO DEL JUEGO =====
    static void inicioJuego() {
        escena_papel_suelo();
        escena_mirando_papel();
        escena_cama_conver();
        escenaPrincipal();
    }

    static void escena_papel_suelo() {
        Reproductor.parar();
        FuncionesGraficas.FotoyMensaje(
                "Una hoja en el suelo",
                "src/main/java/resources/imagenes/inicio_del_juego/imagen_perso_papel_fondo.png",
                "Un dia cualquiera " + nombreHombre + " y " + nombreMujer + " estaban dando una vuelta por la ciudad y se encontraron un papel en el suelo...",
                0.5,
                false
        );
    }

    static void escena_mirando_papel() {
        Reproductor.parar();
        Reproductor.reproducir("src/main/java/resources/Sonidos/Jeroglificos.mp3");
        FuncionesGraficas.FotoyMensaje(
                "Mirando el papel",
                "src/main/java/resources/imagenes/inicio_del_juego/papel_jeroglificos.png",
                "El papel contenía unos extraños jeroglificos en un idioma que no entendian...",
                0.5,
                false
        );
        Reproductor.parar();
    }

    static void escena_cama_conver() {
        Reproductor.parar();
        FuncionesGraficas.FotoyMensaje(
                "Conversación",
                "src/main/java/resources/imagenes/inicio_del_juego/conver_cama.png",
                "Esa misma noche " + nombreHombre + " y " + nombreMujer + " estuvieron horas y horas hablando del tema...",
                0.5,
                false
        );
    }

    // ===== ESCENA PRINCIPAL (CIUDAD) =====
    static void escenaPrincipal() {
        Reproductor.parar();

        String[] opciones = {
                "1. Ir a plaza central",
                "2. Ir a mercado mayorista",
                "3. Ir a barrio antiguo",
                "4. Ir a alameda aullante",
                "5. Ir a estación central",
                "6. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Ciudad",
                opciones,
                "src/main/java/resources/imagenes/escena_principal_(ciudad)/ciudad_juego.png",
                "Te encuentras en la ciudad. ¿A dónde quieres ir?",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> plazaCentral();
            case 1 -> mercadoMayorista();
            case 2 -> barrioAntiguo();
            case 3 -> alamedaAullante();
            case 4 -> estacionCentral();
            case 5 -> salirJuego();
            default -> escenaPrincipal();
        }
    }

    // ===== PLAZA CENTRAL =====
    static void plazaCentral() {
        Reproductor.parar();
        Reproductor.reproducirBucle("src/main/java/resources/Sonidos/Ciudad.mp3");

        String[] opciones = {
                "1. Hablar con el señor",
                "2. Observar la alcantarilla",
                "3. Ir al barrio antiguo",
                "4. Ir a alameda aullante",
                "5. Ir a mercado mayorista",
                "6. Ir a estación central",
                "7. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Plaza Central",
                opciones,
                "src/main/java/resources/imagenes/plaza_central/plaza_central.png",
                "La aventura comienza en la plaza central.\n¿Qué quieres hacer?",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                if (!hablarSeñor) {
                    FuncionesGraficas.FotoyMensaje(
                            "Señor misterioso",
                            "src/main/java/resources/imagenes/plaza_central/EscenaHablandoConSeñorfuera.png",
                            "Se conoce que hace muchos años aqui habia una civilizacion escondida...",
                            0.4,
                            false
                    );
                    hablarSeñor = true;
                } else {
                    FuncionesGraficas.FotoyMensaje(
                            "Señor",
                            "src/main/java/resources/imagenes/plaza_central/EscenaHablandoConSeñorfuera.png",
                            "No tengo nada nuevo que decir hijos mios,mucha suerte en vuestro viaje",
                            0.4,
                            false
                    );
                }
                Reproductor.parar();
                Reproductor.reproducir("src/main/java/resources/imagenes/plaza_central/HablandoConSeñor.mp3");
                Reproductor.parar();
                plazaCentral();
            }
            case 1 -> {
                escenaAlcantarilla();
                plazaCentral();
            }
            case 2 -> barrioAntiguo();
            case 3 -> alamedaAullante();
            case 4 -> mercadoMayorista();
            case 5 -> estacionCentral();
            case 6 -> salirJuego();
            default -> plazaCentral();
        }
    }

    static void escenaAlcantarilla() {
        Reproductor.parar();
        FuncionesGraficas.FotoyMensaje(
                "Alcantarilla",
                "src/main/java/resources/imagenes/plaza_central/Observando_alcantarilla_mercado_central.jpg",
                "En esta alcantarilla se escuchan ruidos a menudo...",
                0.4,
                false
        );
        FuncionesGraficas.FotoyMensaje(
                "Dentro de la alcantarilla",
                "src/main/java/resources/imagenes/plaza_central/alcantarilla_principio.png",
                "",
                0.4,
                false
        );
    }

    // ===== ALAMEDA AULLANTE =====
    static void alamedaAullante() {
        Reproductor.parar();
        Reproductor.reproducirBucle("src/main/java/resources/Sonidos/Buho.mp3", -1);

        String[] opciones = {
                "1. Buscar tras el árbol",
                "2. Volver a la plaza central",
                "3. Bifurcación de caminos",
                "4. Subirse al arbol",
                "5. Ir a la central nuclear",
                "6. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Alameda aullante",
                opciones,
                "src/main/java/resources/imagenes/alameda_aullante/alameda_aullante.png",
                "La alameda está silenciosa, se oyen ruidos extraños.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Tras el árbol",
                        "src/main/java/resources/imagenes/alameda_aullante/buscando_detras.png",
                        "Aqui parece que hay otra especie de pista...",
                        0.4,
                        false
                );
                alamedaAullante();
            }
            case 1 -> plazaCentral();
            case 2 -> bifurcacionCaminos();
            case 3 -> subirArbol();
            case 4 -> {
                if (subirArbol) {
                    Reproductor.parar();
                    centralNuclear();
                } else {
                    FuncionesGraficas.warning(
                            "Atencion",
                            "Deberias tener algo mas de vision para orientarte"
                    );
                    alamedaAullante();
                }
            }
            case 5 -> salirJuego();
            default -> alamedaAullante();
        }
    }

    static void subirArbol() {
        Reproductor.parar();
        FuncionesGraficas.FotoyMensaje(
                "Subir al arbol",
                "src/main/java/resources/Imagenes/alameda_aullante/subida_arbol_nuclear.png",
                "Eh mira " + nombreMujer + " desde aqui se ve una central nuclear!!",
                0.4,
                false
        );
        subirArbol = true;
        alamedaAullante();
    }

    // ===== BIFURCACIÓN DE CAMINOS =====
    static void bifurcacionCaminos() {
        Reproductor.parar();

        String[] opciones = {
                "1. Ir hacia la izquierda",
                "2. Ir hacia la derecha",
                "3. Volver atrás"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Bifurcación",
                opciones,
                "src/main/java/resources/imagenes/alameda_aullante/bifurcacion_camino.png",
                "Te encuentras en una bifurcación. ¿Hacia dónde quieres ir?",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Camino de la izquierda",
                        "src/main/java/resources/imagenes/alameda_aullante/bifurcacion_camino.png",
                        "Escoges el camino de la izquierda...",
                        0.4,
                        false
                );
                Reproductor.parar();
                Reproductor.reproducir("src/main/java/resources/sonidos/Acertijo.mp3");
                acertijoRio();
                alamedaAullante();
            }
            case 1 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Camino de la derecha",
                        "src/main/java/resources/imagenes/alameda_aullante/camino_derecha.png",
                        "Coges valor y te adentras por el camino de la derecha",
                        0.4,
                        false
                );
                Reproductor.parar();
                jumpScare();
                Reproductor.parar();
                alamedaAullante();
            }
            case 2 -> alamedaAullante();
            default -> bifurcacionCaminos();
        }
    }

    // ===== CENTRAL NUCLEAR =====
    static void centralNuclear() {
        Reproductor.parar();

        String[] opciones = {
                "1. Investigar alrededores",
                "2. Hablar con el segurata",
                "3. Volver a la estación central",
                "4. Volver a la alameda aullante",
                "5. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Central nuclear",
                opciones,
                "src/main/java/resources/imagenes/central_nuclear/conversacion_guardia.png",
                "¡Por fin llegamos a la central nuclear!\nPero... hay un guardia, ¿que hacemos?",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                if (pergamino1 && pergamino2 && pergamino3 && permisoHomer) {
                    Reproductor.parar();
                    investigarAlrededores();
                } else {
                    FuncionesGraficas.warning(
                            "Atencion",
                            "Parece que no tenemos las cosas necesarias para ello"
                    );
                    centralNuclear();
                }
            }
            case 1 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Hablando con homer",
                        "src/main/java/resources/imagenes/central_nuclear/conversacion_guardia.png",
                        "Homer: muchachos este no es lugar por el cual estar jugando...",
                        0.4,
                        false
                );
                centralNuclear();
            }
            case 2 -> {
                if (dinero >= 10) {
                    estacionCentral();
                } else {
                    FuncionesGraficas.warning(
                            "Sin dinero",
                            "Necesitas al menos 10 monedas para el billete."
                    );
                    centralNuclear();
                }
            }
            case 3 -> alamedaAullante();
            case 4 -> salirJuego();
            default -> centralNuclear();
        }
    }

    // ===== ESTACIÓN CENTRAL =====
    static void estacionCentral() {
        Reproductor.parar();

        String[] opciones = {
                "1. Volver a plaza central",
                "2. Ir a mercado mayorista",
                "3. Ir a central nuclear (si tienes dinero)",
                "4. Ir al segundo piso",
                "5. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Estación central",
                opciones,
                "src/main/java/resources/imagenes/estacion_central/estacion_central.png",
                "La estación central está llena de viajeros.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> plazaCentral();
            case 1 -> mercadoMayorista();
            case 2 -> {
                if (dinero >= 10) {
                    centralNuclear();
                } else {
                    FuncionesGraficas.warning(
                            "Sin dinero",
                            "Necesitas al menos 10 monedas para el billete."
                    );
                    estacionCentral();
                }
            }
            case 3 -> irSegundoPiso();
            case 4 -> salirJuego();
            default -> estacionCentral();
        }
    }

    // ===== BARRIO ANTIGUO =====
    static void barrioAntiguo() {
        Reproductor.parar();

        String[] opciones = {
                "1. Entrar a la biblioteca",
                "2. Volver a la plaza central",
                "3. Ir al callejón oscuro",
                "4. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Barrio antiguo",
                opciones,
                "src/main/java/resources/imagenes/barrio_antiguo/biblioteca_callejon.png",
                "Parece que hemos llegado a la biblioteca, a ver que encontramos por aqui...",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> entrarBiblioteca();
            case 1 -> plazaCentral();
            case 2 -> callejonOscuro();
            case 3 -> salirJuego();
            default -> barrioAntiguo();
        }
    }

    static void entrarBiblioteca() {
    Reproductor.parar();

    String[] opciones = {
        "1. Hablar con el bibliotecario",
        "2. Observar librería",
        "3. Resolver acertijo"
    };

    int eleccion = FuncionesGraficas.FotoMensajeMenu(
            "Biblioteca",
            opciones,
            "src/main/java/resources/imagenes/Libreria/libreria_grande.png",
            "La biblioteca está llena de estanterías y libros antiguos,nada especial.",
            0.4,
            false
    );

    switch (eleccion) {
        
case 0 -> { // Hablar con el bibliotecario
    if (pergamino2) {
        // Mensaje con imagen + sonido UNA sola vez
        FuncionesGraficas.FotoyMensaje(
                    "Bibliotecario",
                    "src/main/java/resources/imagenes/Libreria/hablando_bibliotecario.png",
                    "Revisas la librería en busca de algo interesante.",
                    0.4,
                    false
            );
        // Después de hablar, te vas al barrio antiguo (o donde quieras seguir)
        barrioAntiguo();
    } else {
        FuncionesGraficas.warning(
                "Bibliotecario",
                "Os deseo suerte en vuestra aventura, pero aún no he podido encontrar nada especial..."
        );
        // Si NO tienes el pergamino, sigues en la biblioteca
        entrarBiblioteca();
    }
}
        

        case 1 -> { // Observar librería
            // FG.Imagen
            FuncionesGraficas.FotoyMensaje(
                    "Librería",
                    "src/main/java/resources/imagenes/Libreria/libreria_grande.png",
                    "Revisas la librería en busca de algo interesante.",
                    0.4,
                    false
            );

            // escenaHabLibMujer = FG.ImagenTexto
            FuncionesGraficas.FotoyMensaje(
                    "Conversación",
                    "src/main/java/resources/imagenes/Libreria/Libreria.png",
                    nombreMujer + " hojea un libro antiguo mientras " + nombreHombre +
                    " observa unas notas misteriosas en una esquina.",
                    0.4,
                    false
            );

            verAcertijo2 = true; 
            entrarBiblioteca();
        }

        case 2 -> { // Resolver acertijo
            if (!verAcertijo2) {
                // FG.Warning (parece una librería normal)
                FuncionesGraficas.warning(
                        "Nada sospechoso",
                        "Por ahora parece una librería normal, quizá deberías investigar un poco más."
                );
                entrarBiblioteca();
            } else {
                
                acertijo2();
            }
        }

        default -> barrioAntiguo(); // salir de la biblioteca hacia el barrio antiguo
    }
}


    static void callejonOscuro() {
        Reproductor.parar();
        jumpScare();
        Reproductor.parar();
        barrioAntiguo();

    }

    // ===== MERCADO MAYORISTA =====
    static void mercadoMayorista() {
        Reproductor.parar();
        Reproductor.reproducir("src/main/java/resources/Sonidos/MercadoMayoristaAudio.mp3");

        String[] opciones = {
                "1. Ir a la tienda",
                "2. Ir al bazar",
                "3. Ir a estación central",
                "4. Ir a plaza central",
                "5. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Mercado mayorista",
                opciones,
                "src/main/java/resources/imagenes/mercado_mayorista/mercado_mayorista.png",
                "El mercado está lleno de puestos y gente.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> irALaTienda();
            case 1 -> irALBazar();
            case 2 -> estacionCentral();
            case 3 -> plazaCentral();
            case 4 -> salirJuego();
            default -> mercadoMayorista();
        }
    }

    // ===== ZONA TIENDA / BAZAR =====
    static void irALaTienda() {
        Reproductor.parar();
        Reproductor.reproducir("src/main/java/resources/Sonidos/TiendaCampanas.mp3");

        String[] opciones = {
                "1. Ir a la tienda",
                "2. Colarse en la parte de atrás de la tienda",
                "3. Ir atrás",
                "4. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Calle de la tienda",
                opciones,
                "src/main/java/resources/imagenes/mercado_mayorista/yendo_tienda.png",
                "A ver si pudiesemos conseguir algo de informacion.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Interior tienda",
                        "src/main/java/resources/imagenes/mercado_mayorista/dependiente_mercado.png",
                        "Buenos dias señor, nos han llegado rumores de que por aqui hace tiempo habia una persona\nque sabia algo de algun secreto de la ciudad, es eso cierto?\nDependiente: pues la verdad que no lo se, lo unico que sé es que en la parte de atras de la tienda\nhay una entrada que da al almacen y tiene una caja fuerte que nunca he podido desbloquear.\nSeria usted tan amable de dejarnos ver esa caja fuerte?\nDependiente: lo siento chicos el acceso no esta permitido para personal no autorizado, que tengais buen dia.",
                        0.4,
                        false
                );
                colarseAtrasTienda=true;
                irALaTienda();
            }
            case 1 -> {
                if (!colarseAtrasTienda) {
                    FuncionesGraficas.warning(
                            "Aviso",
                            "No sabes donde es, deberias de obtener informacion del sitio"
                    );
                } else {
                    colarseTienda();
                }
                irALaTienda();
            }
            case 2 -> mercadoMayorista();
            case 3 -> salirJuego();
            default -> irALaTienda();
        }
        Reproductor.parar();
    }

    static void irALBazar() {
        Reproductor.parar();
        Reproductor.reproducirBucle("src/main/java/resources/Sonidos/BazarHablando.mp3");

        String[] opciones = {
                
                "1. Volver atrás",
                "2. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Bazar Chino",
                opciones,
                "src/main/java/resources/imagenes/mercado_mayorista/Hablandoconchinos.png",
                "Buenas señora sabe usted algo del misterio de la ciudad?\nDependienta:...\nDependienta:...\nDependienta:...\nParece que no nos entiende,vámonos",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> mercadoMayorista();
            case 1 -> salirJuego();
            default -> irALBazar();
        }
    }

    static void colarseTienda() {
        Reproductor.parar();

        String[] opciones = {
                "1. Forzar cerradura",
                "2. Volver atrás",
                "3. Salir del Juego"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Puerta trasera",
                opciones,
                "src/main/java/resources/imagenes/mercado_mayorista/puerta_atras_tienda.png",
                "Llegas a la parte trasera de la tienda, ves una puerta con candado y la fuerzas para entrar.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                acertijo1();
                
            }
            case 1 -> { /* volver sin hacer nada */ }
            case 2 -> salirJuego();
            default -> colarseTienda();
        }
    }

    // ===== ACERTIJO 1: CAJA FUERTE (FIBONACCI) =====
static int acertijo1() {

    Reproductor.parar();
FuncionesGraficas.FotoyMensaje(
            "Viendo caja fuerte",
            "src/main/java/resources/imagenes/mercado_mayorista/abriendo caja fuerte.png",
            "Observas la sucesión de números en la caja fuerte.\n¿Qué número falta al final de la sucesión?",
            0.4,
            false
    );
    // Escena de la caja fuerte con la sucesión
    FuncionesGraficas.FotoyMensaje(
            "Acertijo de la caja fuerte",
            "src/main/java/resources/imagenes/mercado_mayorista/sucesion.png",
            "Observas la sucesión de números en la caja fuerte.\n¿Qué número falta al final de la sucesión?",
            0.4,
            false
    );

    // Pedir el término que falta (14º Fibonacci)
    int n = FuncionesGraficas.pedirEntero(
            "Acertijo",
            "Introduce el siguiente número de la sucesión:"
    );

    int correcto = 377;   // 14º número de Fibonacci (1,1,2,3,5,8,13,21,34,55,89,144,233,377)

    if (n != correcto) {
        // Respuesta incorrecta
        FuncionesGraficas.warning(
                "Incorrecto",
                "No es el número correcto."
        );
        return n;
    }

    // Respuesta correcta
    FuncionesGraficas.mostrarMensaje(
            "Correcto",
            "¡Has acertado el número de la sucesión!",
            1
    );

    // Menú de la caja abierta: coger pergamino, coger dinero o cerrar
    String[] opciones = {
            "1. Coger pergamino",
            "2. Coger dinero",
            "3. Cerrar la caja fuerte"
    };

    int eleccion = FuncionesGraficas.menu(
            "Caja fuerte abierta",
            opciones,
            opciones.length
    );

    switch (eleccion) {
        case 0 -> { // Coger pergamino
            if (!pergamino1) {
                pergamino1 = true;
                FuncionesGraficas.mostrarMensaje(
                        "Pergamino",
                        "Has cogido el primer pergamino.",
                        1
                );
            } else {
                FuncionesGraficas.warning(
                        "Pergamino",
                        "Ya tienes este pergamino."
                );
            }
        }
        case 1 -> { // Coger dinero
            if (dinero == 0) {
                dinero = dinero + 500;  // por ejemplo, 500 monedas
                FuncionesGraficas.mostrarMensaje(
                        "Dinero",
                        "Has cogido 500 monedas de la caja fuerte.",
                        1
                );
            } else {
                FuncionesGraficas.warning(
                        "Dinero",
                        "Ya has cogido el dinero de esta caja."
                );
            }
        }
        case 2 -> {
            colarseTienda();
        }
        default -> {
            // Opción no válida → no haces nada especial
        }
    }

    // Escena de “habilidad del hombre” antes de volver al flujo de la tienda
    FuncionesGraficas.FotoyMensaje(
            "Habilidad de " + nombreHombre,
            "src/main/java/resources/imagenes/mercado_mayorista/habilidades_aventura.png",
            nombreHombre + " ha obtenido la habilidad de razonamiento logico gracias al descubrir la solucion al acertijo de la sucesion de Fibonacci",
            0.4,
            false
    );

    // Volver al flujo de la puerta trasera / tienda
    acertijo1();

    return n;
}


    static void salirJuego() {
        Reproductor.parar();
        FuncionesGraficas.warning(
                "Salir del juego",
                "Has decidido salir. ¡Gracias por jugar, " + nombreJug + "!"
        );
        System.exit(0);
    }

    // ===== ACERTIJO DEL RÍO =====
    static void acertijoRio() {
        Reproductor.parar();

        String[] opcionesMenu = {
                "Salir",
                "Hacer un cruce",
                "Ver reglas"
        };

        boolean salir = false;

        while (!salir) {
            mostrarEstadoRio();

            if (todosCruzadosRio()) {
                FuncionesGraficas.mostrarMensaje(
                        "¡Enhorabuena!",
                        "Has conseguido que todos crucen el río en " + tiempoTotal + " minutos.",
                        1
                );
                break;
            }

            int opcion = FuncionesGraficas.menu(
                    "Acertijo del río en el bosque",
                    opcionesMenu,
                    opcionesMenu.length
            );

            switch (opcion) {
                case 1 -> hacerCruceRio();
                case 2 -> mostrarReglasRio();
                default -> salir = true;
            }
        }
    }

    // ===== FUNCIONES DE APOYO DEL RÍO =====
    static void mostrarEstadoRio() {
        String estado = "";

        estado += "TIEMPO TOTAL: " + tiempoTotal + " minutos\n\n";

        estado += "Lado INICIAL (linterna: ";
        estado += linternaLadoInicial ? "SÍ" : "NO";
        estado += ")\n";

        for (int i = 0; i < nombres.length; i++) {
            if (ladoInicial[i]) {
                estado += "  " + nombres[i] + "(" + tiempos[i] + ")\n";
            }
        }

        estado += "\nLado FINAL (linterna: ";
        estado += !linternaLadoInicial ? "SÍ" : "NO";
        estado += ")\n";

        for (int i = 0; i < nombres.length; i++) {
            if (!ladoInicial[i]) {
                estado += "  " + nombres[i] + "(" + tiempos[i] + ")\n";
            }
        }

        FuncionesGraficas.mostrarDatos("Estado actual del acertijo", estado);
    }

    static boolean todosCruzadosRio() {
        for (boolean b : ladoInicial) {
            if (b) return false;
        }
        return true;
    }

    static void hacerCruceRio() {
        String ladoTexto = linternaLadoInicial
                ? "lado INICIAL al lado FINAL"
                : "lado FINAL al lado INICIAL";

        String disponibles = "Personas que pueden cruzar ahora:\n";
        for (int i = 0; i < nombres.length; i++) {
            if (ladoInicial[i] == linternaLadoInicial) {
                disponibles += "  - " + nombres[i] + " (" + tiempos[i] + " min)\n";
            }
        }
        FuncionesGraficas.mostrarDatos("Posibles cruces", disponibles);

        String entrada = FuncionesGraficas.pedirDatos(
                "Cruce",
                "Escribe 1 o 2 nombres que cruzan de " + ladoTexto +
                        " (ej.: \"Ana Bruno\" o \"Diego\"):"
        );

        if (entrada == null) return;

        entrada = entrada.trim();
        if (entrada.isEmpty()) return;

        String[] textos = entrada.split("\\s+");
        if (textos.length > 2) {
            FuncionesGraficas.mostrarMensaje(
                    "Aviso",
                    "Solo se tendrán en cuenta los dos primeros nombres.",
                    0
            );
        }

        int[] idxCruzan = { -1, -1 };
        int cuenta = 0;

        for (int i = 0; i < textos.length && i < 2; i++) {
            int indice = buscarIndicePersona(textos[i]);
            if (indice != -1 && ladoInicial[indice] == linternaLadoInicial) {
                idxCruzan[cuenta] = indice;
                cuenta++;
            }
        }

        if (cuenta == 0) {
            FuncionesGraficas.mostrarMensaje(
                    "Error",
                    "No has elegido ninguna persona válida para este lado.",
                    0
            );
            return;
        }

        int tiempoCruce = 0;
        for (int i = 0; i < cuenta; i++) {
            int idx = idxCruzan[i];
            if (tiempos[idx] > tiempoCruce) {
                tiempoCruce = tiempos[idx];
            }
        }

        for (int i = 0; i < cuenta; i++) {
            int idx = idxCruzan[i];
            ladoInicial[idx] = !ladoInicial[idx];
        }

        tiempoTotal += tiempoCruce;
        linternaLadoInicial = !linternaLadoInicial;

        String resumen = "Se han movido: ";
        for (int i = 0; i < cuenta; i++) {
            int idx = idxCruzan[i];
            resumen += nombres[idx] + " ";
        }
        resumen += "\nTiempo de este cruce: " + tiempoCruce + " min";
        resumen += "\nTiempo total acumulado: " + tiempoTotal + " min";

        FuncionesGraficas.mostrarDatos("Resultado del cruce", resumen);
    }

    static int buscarIndicePersona(String nombre) {
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    static void mostrarReglasRio() {
        String reglas;
        reglas = """
                 REGLAS DEL ACERTIJO:
                   - Cuatro amigos deben cruzar el r\u00edo con una sola balsa.
                 - Solo caben 2 personas m\u00e1ximo en la balsa.
                 - Tiempos: Ana=1, Bruno=2, Carla=5, Diego=10.
                 - Si cruzan dos, cuenta el tiempo del m\u00e1s lento.
                 - Solo hay una linterna y siempre debe ir en la balsa (ida y vuelta).
                 - El programa no te da la soluci\u00f3n: t\u00fa pruebas tus jugadas.""";
        FuncionesGraficas.mostrarDatos("Reglas del juego", reglas);
    }

    static void jumpScare() {
        Reproductor.parar();
        Reproductor.reproducir("src/main/java/resources/Sonidos/jumpscare.mp3");

        FuncionesGraficas.FotoyMensaje(
                "¡¡¡JUMPSCARE!!!",
                "src/main/java/resources/imagenes/alameda_aullante/jumpscare.jpg",
                "¡¡¡AHHHHHHH!!!\n\n¡Algo terrible te ataca!",
                7.0,
                false
        );
    }

    static void investigarAlrededores() {
        Reproductor.parar();

        String[] opciones = {
                "1. Abrir alcantarilla",
                "2. Ir atrás"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "En los alrededores de la central nuclear bajo la supervision de Homer",
                opciones,
                "src/main/java/resources/imagenes/central_nuclear/alcantarillacerradacentral.png",
                "Espera, ¿qué es esto?",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                if (llaveRio) {
                    FuncionesGraficas.FotoyMensaje(
                            "Aliens agradecidos",
                            "src/main/java/resources/imagenes/central_nuclear/alcantarilla_abierta_nuclear.png",
                            nombreMujer + " creo que hemos resuelto lo que estabamos buscando...",
                            0.4,
                            false
                    );
                    FuncionesGraficas.FotoyMensaje(
                            "Ciudad subterranea de los aliens",
                            "src/main/java/resources/imagenes/central_nuclear/ciudad_aliens.png",
                            "",
                            0.4,
                            false
                    );
                    FuncionesGraficas.mostrarMensaje(
                            "Armonía",
                            "Al cabo del tiempo aliens y humanos aprendieron a vivir en humildad y armonía...",
                            1
                    );
                    FuncionesGraficas.FotoyMensaje(
                            "Plaza renovada",
                            "src/main/java/resources/imagenes/plaza_central/CON CIUDADSUBTERRANEA.png",
                            "La plaza central ha cambiado tras tus acciones.",
                            0.4,
                            false
                    );

                    finalFeliz();
                    salirJuego();

                } else {
                    FuncionesGraficas.warning(
                            "Bloqueada",
                            "Parece que no puedes abrir la alcantarilla, te falta algo..."
                    );
                    centralNuclear();
                }
            }
            case 1 -> centralNuclear();
            default -> centralNuclear();
        }
    }

    static void finalFeliz() {
        Reproductor.parar();
        Reproductor.reproducir("src/main/java/resources/Sonidos/Fantasia.mp3");

        FuncionesGraficas.FotoyMensaje(
                "¡Enhorabuena!",
                "src/main/java/resources/imagenes/final/final_feliz.png",
                "¡Felicidades " + nombreJug + "! Has resuelto el misterio y salvado la ciudad.",
                0.4,
                false
        );

        FuncionesGraficas.mostrarMensaje(
                "Fin del juego",
                "Has completado la aventura. ¡Gran trabajo, " + nombreJug + "!",
                1
        );
    }

    static void irSegundoPiso() {
        Reproductor.parar();

        if (pergamino1) {
            FuncionesGraficas.FotoyMensaje(
                    "Escaleras con extraño grafitti",
                    "src/main/java/resources/imagenes/Acertijo/pista_acertijo1_nuclear.png",
                    "",
                    0.4,
                    false
            );
        } else {
            FuncionesGraficas.FotoyMensaje(
                    "Escaleras al segundo piso",
                    "src/main/java/resources/imagenes/Acertijo/escaleras_segundo_piso.png",
                    "",
                    0.4,
                    false
            );
        }

        FuncionesGraficas.FotoyMensaje(
                "Segundo piso",
                "src/main/java/resources/imagenes/Acertijo/segundopiso_nada.png",
                "No hay nada.",
                0.4,
                false
        );

        estacionCentral();
    }


// ====== FUNCIÓN PRINCIPAL DEL ACERTIJO ======
static void acertijo2() {

    String[] opciones = {
        "Salir",
        "Ver reglas",
        "Ver estado actual",
        "Proponer una asignación",
        "Comprobar si cumple las pistas"
    };

    boolean salir = false;

    while (!salir) {

        int op = FuncionesGraficas.menu(
                "Acertijo de la Biblioteca",
                opciones,
                opciones.length
        );

        if (op == 1) {                // Ver reglas
            mostrarReglasBiblioteca();
        } else if (op == 2) {         // Ver estado
            mostrarEstadoBiblioteca();
        } else if (op == 3) {         // Proponer asignación
            proponerAsignacionBiblioteca();
        } else if (op == 4) {         // Comprobar condiciones
            comprobarBiblioteca();
        } else {                      // Salir
            salir = true;
        }
    }

    // al salir del acertijo vuelves a la biblioteca
    entrarBiblioteca();
}


// ====== MOSTRAR REGLAS ======
static void mostrarReglasBiblioteca() {
    String texto;
        texto = """
                ACERTIJO DE LA BIBLIOTECA
                     Hay 5 estantes con un n\u00famero distinto de libros: 3, 5, 7, 9 y 11.
                Los estantes est\u00e1n etiquetados con las letras A, B, C, D y E.
                Solo UNA etiqueta corresponde al estante correcto.
                     Pistas del bibliotecario:
                 - A tiene m\u00e1s libros que B.   (A > B)
                 - C tiene menos libros que D. (C < D)
                 - E tiene m\u00e1s libros que B y menos que A. (B < E < A)
                 - D tiene menos libros que E. (D < E)
                     Tu objetivo: asignar a A, B, C, D y E uno de los valores
                3, 5, 7, 9, 11 (sin repetir) de forma que se cumplan
                las pistas y, adem\u00e1s, SOLO UN estante tenga el n\u00famero
                que realmente le corresponde.""";
    FuncionesGraficas.mostrarDatos("Reglas Biblioteca", texto);
}

// ====== MOSTRAR ESTADO ACTUAL ======
static void mostrarEstadoBiblioteca() {
    String texto = "Estado actual de la asignación:\n\n";

    for (int i = 0; i < letras.length; i++) {
        texto = texto + letras[i] + " -> ";
        if (asignacion[i] == 0) {
            texto = texto + "(sin asignar)\n";
        } else {
            texto = texto + asignacion[i] + " libros\n";
        }
    }

    texto = texto + "\nNúmeros disponibles: 3, 5, 7, 9, 11 (no deben repetirse).";

    FuncionesGraficas.mostrarDatos("Estado Biblioteca", texto);
}

// ====== PROPONER ASIGNACIÓN ======
static void proponerAsignacionBiblioteca() {

    // reiniciamos asignación
    for (int i = 0; i < asignacion.length; i++) {
        asignacion[i] = 0;
    }

    for (int i = 0; i < letras.length; i++) {
        boolean valido = false;
        while (!valido) {
            String resp = FuncionesGraficas.pedirDatos(
                    "Asignación",
                    "¿Cuántos libros tendrá el estante " + letras[i] +
                    "?\n(Elige uno de: 3, 5, 7, 9, 11, sin repetir)"
            );

            if (resp == null) {
                // si cancela, salimos del todo
                return;
            }

            resp = resp.trim();
            if (resp.isEmpty()) {
                continue;
            }

            int n;
            try {
                n = Integer.parseInt(resp);
            } catch (NumberFormatException e) {
                FuncionesGraficas.warning("Número no válido", "Debes escribir un entero.");
                continue;
            }

            if (!esValorPermitido(n)) {
                FuncionesGraficas.warning(
                        "Valor no permitido",
                        "Solo puedes usar 3, 5, 7, 9 o 11."
                );
            } else if (yaUsadoEnAsignacion(n)) {
                FuncionesGraficas.warning(
                        "Valor repetido",
                        "Ese número de libros ya está asignado a otro estante."
                );
            } else {
                asignacion[i] = n;
                valido = true;
            }
        }
    }

    mostrarEstadoBiblioteca();
}

// comprueba si n está en {3,5,7,9,11}
static boolean esValorPermitido(int n) {
    for (int i = 0; i < librosPosibles.length; i++) {
        if (librosPosibles[i] == n) {
            return true;
        }
    }
    return false;
}

// comprueba si ya hemos usado n en asignacion[]
static boolean yaUsadoEnAsignacion(int n) {
    for (int i = 0; i < asignacion.length; i++) {
        if (asignacion[i] == n) {
            return true;
        }
    }
    return false;
}

// ====== COMPROBAR PISTAS Y "SOLO UNA ETIQUETA CORRECTA" ======
static void comprobarBiblioteca() {

    // Primero verificamos que no quede ningún estante sin asignar
    for (int i = 0; i < asignacion.length; i++) {
        if (asignacion[i] == 0) {
            FuncionesGraficas.warning(
                    "Asignación incompleta",
                    "Aún hay estantes sin número de libros."
            );
            return;
        }
    }

    // índices: 0=A, 1=B, 2=C, 3=D, 4=E
    int A = asignacion[0];
    int B = asignacion[1];
    int C = asignacion[2];
    int D = asignacion[3];
    int E = asignacion[4];

    // comprobar A > B
    boolean ok1 = (A > B);

    // comprobar C < D
    boolean ok2 = (C < D);

    // comprobar B < E < A
    boolean ok3 = (B < E) && (E < A);

    // comprobar D < E
    boolean ok4 = (D < E);

    String resultado = "Comprobando condiciones:\n\n";

    if (ok1) {
        resultado = resultado + "A > B : CUMPLIDA\n";
    } else {
        resultado = resultado + "A > B : NO CUMPLIDA\n";
    }

    if (ok2) {
        resultado = resultado + "C < D : CUMPLIDA\n";
    } else {
        resultado = resultado + "C < D : NO CUMPLIDA\n";
    }

    if (ok3) {
        resultado = resultado + "B < E < A : CUMPLIDA\n";
    } else {
        resultado = resultado + "B < E < A : NO CUMPLIDA\n";
    }

    if (ok4) {
        resultado = resultado + "D < E : CUMPLIDA\n";
    } else {
        resultado = resultado + "D < E : NO CUMPLIDA\n";
    }

    resultado = resultado + "\n";

    boolean todas = ok1 && ok2 && ok3 && ok4;

    if (!todas) {
        resultado = resultado + "Todavía NO cumples todas las pistas.\n";
        resultado = resultado + "Sigue probando otras asignaciones.";
        FuncionesGraficas.mostrarDatos("Resultado Biblioteca", resultado);
        return;
    }

    // ===== COMPROBAR QUE LA ASIGNACIÓN ES EXACTAMENTE LA SOLUCIÓN REAL =====
    boolean esSolucion = true;
    for (int i = 0; i < asignacion.length; i++) {
        if (asignacion[i] != solucionReal[i]) {
            esSolucion = false;
        }
    }

    if (esSolucion) {
        resultado = resultado + "Además, has encontrado la distribución EXACTA de libros.\n";
        resultado = resultado + "¡Has resuelto completamente el acertijo!\n";
        pergamino2 = true;
    } else {
        resultado = resultado + "Cumples las pistas, pero esta no es la distribución real de la biblioteca.\n";
        resultado = resultado + "Sigue probando otra combinación.\n";
    }

    FuncionesGraficas.mostrarDatos("Resultado Biblioteca", resultado);
}

}
