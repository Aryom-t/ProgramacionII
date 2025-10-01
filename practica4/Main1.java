package Practica4;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        System.out.println("=== SISTEMA DE REGISTRO DE EMPLEADOS ===\n");
        
        for (int i = 0; i < 3; i++) {
            System.out.println("--- Empleado Tiempo Completo " + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Salario Anual (Bs.): ");
            double salarioAnual = scanner.nextDouble();
            scanner.nextLine();
            
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
            System.out.println();
        }
        
        for (int i = 3; i < 5; i++) {
            System.out.println("--- Empleado Tiempo Horario " + (i - 2) + " ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Horas Trabajadas: ");
            double horas = scanner.nextDouble();
            System.out.print("Tarifa por Hora (Bs.): ");
            double tarifa = scanner.nextDouble();
            scanner.nextLine();
            
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
            System.out.println();
        }
        
        System.out.println("\n=== RESUMEN DE EMPLEADOS Y SALARIOS ===\n");
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Empleado " + (i + 1) + ":");
            System.out.println(empleados[i].toString());
            System.out.println("Salario Mensual: Bs. " + 
                String.format("%.2f", empleados[i].calcularSalarioMensual()));
            System.out.println("----------------------------------------");
        }
    }
}