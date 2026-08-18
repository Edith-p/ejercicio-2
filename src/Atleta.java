public class Atleta {
    private String nombre; 
    private int numeroParticipante; 
    private int edad; 
    private int tiempo; 
    private int intentos; 
    private int cantidadIntentos; 



    public Atleta (String nombre, int numeroParticipante, int edad){
        this.nombre = nombre; 
        this.numeroParticipante = numeroParticipante; 
        this.edad = edad; 
    }


    String getNombre() {
        return nombre; 
    }    

    int getNumeroParticipante(){
        return numeroParticipante; 
    }

    int getTiempo() {
        return tiempo; 
    }

    
}