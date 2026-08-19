import java.util.Random;

public class Controlador {
    private Atleta[] atleta;
    private Vista vista;
    private Atleta atletaActual;
    private Random random;

    public Controlador() {
        this.atleta = new Atleta[10];
        this.vista = new Vista();
        this.random = new Random();
        this.atletaActual = null;

    }
    
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    Atleta nuevoAtleta = vista.leerDatosAtleta();
                    agregarAtleta(nuevoAtleta);
                    break;
                case 2:
                    vista.mostrarAtletas(atleta);
                    break;
                case 3:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    public void agregarAtleta(Atleta atleta) {
        for (int i = 0; i < this.atleta.length; i++) {
            if (this.atleta[i] == null) {
                this.atleta[i] = atleta;
                break;
            }
        }
    }
    String[] nombres = {
        "Juan", 
        "María", 
        "Pedro", 
        "Ana", 
        "Luis", 
        "Carmen", 
        "Jorge", 
        "Lucía", 
        "Carlos", 
        "Sofía"
        
    };

    String nombre = nombres[random.nextInt(nombres.length)];
    int edad = random.nextInt(23) + 18; // Genera una edad entre 18 y 40
    int numeroParticipante = random.nextInt(1000) + 1; // Genera un número de participante entre 1 y 1000
    Atleta atleta = new Atleta(nombre, edad, numeroParticipante);

    public void nuevoIntento() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de realizar un intento.");
            return;
        }
        int tiempo = vista.solicitarTiempo();
        if (atletaActual.registrarIntento(tiempo)) {
            vista.mostrarMensaje("Intento registrado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo registrar el intento. Intente nuevamente.");
        }
    }
    public void consularTiempos() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de consultar los tiempos.");
            return;
        }
        int[] tiempos = atletaActual.getTiempos();
        vista.mostrarTiempos(tiempos);
    }
    public void consultarIntentos() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de consultar los intentos.");
            return;
        }
        int intentos = atletaActual.getIntentos();
        vista.mostrarIntentos(intentos);
    }
    public void modificarTiempo() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de modificar un tiempo.");
            return;
        }
        int numeroIntento = vista.solicitarNumeroIntento();
        int tiempoNuevo = vista.solicitarTiempo();
        
        if (atletaActual.modificarTiempo(numeroIntento, tiempoNuevo)) {
            vista.mostrarMensaje("Tiempo modificado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo modificar el tiempo. Intente nuevamente.");
        }
    }
    public void mejorPeor() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de consultar el mejor y peor tiempo.");
            return;
        }
        int mejorTiempo = atletaActual.getMejorTiempo();
        int peorTiempo = atletaActual.getPeorTiempo();
        vista.mostrarMejorPeor(mejorTiempo, peorTiempo);
    }
    public void promedio() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de consultar el promedio de tiempos.");
            return;
        }
        double promedio = atletaActual.getPromedioTiempos();
        vista.mostrarPromedio(promedio);
    }
    public void consultarDisponibles() {
        if (atletaActual == null) {
            System.out.println("Registre un atleta antes de consultar los intentos disponibles.");
            return;
        }
        vista.mostrarIntentosRealizados(
            atletaActual.getintentosRealizados()
        );
        vista.mostrarIntentosRestantes(
            atletaActual.getintentosRestantes()
        );
        vista.mostrarDisponibles(
            atletaActual.getintentosDisponibles()
        );
    }
    public void salir() {
        System.out.println("Programa finalizado. ¡Hasta luego!");
    }
}