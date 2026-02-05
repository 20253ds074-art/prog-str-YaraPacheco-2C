import java.util.Scanner;

public class InputValidator {

    public double getValidkG(String message, Scanner sc, double min, double max){
        double value;
        while(true){
            System.out.println(message);
            if(sc.hasNextDouble()){
                value= sc.nextDouble();
                if(value>min&& value<=max){
                    return value;
                }
                System.out.println("Rebasaste el rango requerido 0.1 a 50.0");
            }else{
                System.out.println("El valor ingresado no es numerico");
                sc.nextLine();
            }
        }
    }
    public int getValidKm(String message, Scanner sc, double min, double max){
        int value;
        while(true){
            System.out.println(message);
            if(sc.hasNextInt()){
                value= sc.nextInt();
                if(value>min&& value<=max){
                    return value;
                }
                System.out.println("Rebasaste el rango requerido de 1 a 2000");
            }else{
                System.out.println("El valor ingresado no es numerico");
                sc.nextLine();
            }
        }
    }
    public int getValidServicio(String message, Scanner sc, double min, double max){
        int value;
        while (true){
            System.out.println(message);
            if (sc.hasNext()){
                value=sc.nextInt();
                if (value==1&& value==2){
                    return value;
                }
            }
            System.out.println("Rebasaste el rango requerido de 1 a 2000");

        }
    }
}