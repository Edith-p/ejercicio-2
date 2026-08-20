public class Controlador {
    private Atleta[] atleta;
    private Vista vista;
    private Atleta atletaActual;

    public Controlador() {
        this.atleta = new Atleta[10];
        this.vista = new Vista();
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
                    nuevoIntento();
                    break;
                case 3:
                    consularTiempos();
                    break;
                case 4:
                    consultarIntentos();
                    break;
                case 5:
                    modificarTiempo();
                    break;
                case 6:
                    promedio();
                    break;
                case 7:
                    mejorPeor();
                    break;
                case 8:
                    consultarDisponibles();
                    break;
                case 9:
                    salir();
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 9);
    }

    public void agregarAtleta(Atleta atleta) {

    for (int i = 0; i < this.atleta.length; i++) {

        if (this.atleta[i] == null) {
            this.atleta[i] = atleta;
            this.atletaActual = atleta;
            break;
        }
    }
}
if (position == -1) {
    System.out.println("No hay espacio para registrar más atletas.");
    return;
}

    public void registrarAtleta(int posicion) {
        Atleta nuevoAtleta = vista.leerAtleta();
        atleta[posicion] = nuevoAtleta;
        atletaActual = nuevoAtleta;
        System.out.println("Atleta registrado correctamente.");
}

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
        System.out.println("Registre un atleta antes de consultar los intentos.");
        return;
    }

    int intentosRealizados = atletaActual.intentosRealizados();
    int intentosRestantes = atletaActual.intentosRestantes();

    vista.mostrarDisponibles(
        intentosRealizados,
        intentosRestantes
    );
}
    public void salir() {
        System.out.println("Programa finalizado. ¡Hasta luego!");
    }
}