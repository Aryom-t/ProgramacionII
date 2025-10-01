package Practica4;

public class EmpleadoTiempoCompleto extends Empleado {

    private double salarioAnual;

    public EmpleadoTiempoCompleto(String nombre, double salarioAnual) {
        super(nombre);
        this.salarioAnual = salarioAnual;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioAnual / 12.0;
    }

    @Override
    public String toString() {
        return super.toString() + " (Tiempo Completo)\n"
                + "Salario Anual: Bs. " + String.format("%.2f", salarioAnual);
    }
}
