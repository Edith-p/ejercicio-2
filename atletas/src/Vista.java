import java.util.Scanner;

public class Vista{
    private Scanner sc = new Scanner(System.in);
    
    public int mostrarMenu() {
      System.out.println("Menú de los tiempos");
      System.out.println("1. Ingresar un nuevo atleta");
      System.out.println("2. Ingresar un nuevo intento");
      System.out.println("3. Consultar los tiempos registrados");
      System.out.println("4. Consultar el registro de un intento");
      System.out.println("5.Modificar el tiempo de un intento ");
      System.out.println("6. Mostrar el mejor tiempo y el tiempo más alto"); 
      System.out.println("7. Consultar registros disponibles"); 
      System.out.println("8. Salir"); 

      return Integer.parseInt(sc.nextLine());

    }

}