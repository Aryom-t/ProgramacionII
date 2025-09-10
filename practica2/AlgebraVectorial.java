package Practica2;

public class AlgebraVectorial {

    private Vector3D vectorA;
    private Vector3D vectorB;

    public AlgebraVectorial() {
        this.vectorA = new Vector3D(0, 0, 0);
        this.vectorB = new Vector3D(0, 0, 0);
    }

    public AlgebraVectorial(Vector3D a, Vector3D b) {
        this.vectorA = a;
        this.vectorB = b;
    }

    public AlgebraVectorial(double ax, double ay, double az, double bx, double by, double bz) {
        this.vectorA = new Vector3D(ax, ay, az);
        this.vectorB = new Vector3D(bx, by, bz);
    }

    private Vector3D suma(Vector3D a, Vector3D b) {
        return new Vector3D(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    private Vector3D resta(Vector3D a, Vector3D b) {
        return new Vector3D(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    private double magnitud(Vector3D v) {
        return Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY() + v.getZ() * v.getZ());
    }

    private double productoEscalar(Vector3D a, Vector3D b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    private Vector3D productoVectorial(Vector3D a, Vector3D b) {
        double x = a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getZ() * b.getX() - a.getX() * b.getZ();
        double z = a.getX() * b.getY() - a.getY() * b.getX();
        return new Vector3D(x, y, z);
    }

    private Vector3D multiplicarEscalar(double escalar, Vector3D v) {
        return new Vector3D(escalar * v.getX(), escalar * v.getY(), escalar * v.getZ());
    }

    public boolean perpendicular() {
        Vector3D suma = suma(vectorA, vectorB);
        Vector3D resta = resta(vectorA, vectorB);
        double magSuma = magnitud(suma);
        double magResta = magnitud(resta);
        return Math.abs(magSuma - magResta) < 1e-10;
    }

    public boolean perpendicular(boolean metodo2) {
        Vector3D resta1 = resta(vectorA, vectorB);
        Vector3D resta2 = resta(vectorB, vectorA);
        double mag1 = magnitud(resta1);
        double mag2 = magnitud(resta2);
        return Math.abs(mag1 - mag2) < 1e-10;
    }

    public boolean perpendicular(Vector3D a, Vector3D b) {
        double producto = productoEscalar(a, b);
        return Math.abs(producto) < 1e-10;
    }

    public boolean perpendicular(double dummy) {
        Vector3D suma = suma(vectorA, vectorB);
        double magSumaCuadrado = magnitud(suma) * magnitud(suma);
        double magACuadrado = magnitud(vectorA) * magnitud(vectorA);
        double magBCuadrado = magnitud(vectorB) * magnitud(vectorB);
        return Math.abs(magSumaCuadrado - (magACuadrado + magBCuadrado)) < 1e-10;
    }

    public boolean paralela() {
        if (magnitud(vectorB) < 1e-10) {
            return magnitud(vectorA) < 1e-10;
        }

        double r;
        if (Math.abs(vectorB.getX()) > 1e-10) {
            r = vectorA.getX() / vectorB.getX();
        } else if (Math.abs(vectorB.getY()) > 1e-10) {
            r = vectorA.getY() / vectorB.getY();
        } else {
            r = vectorA.getZ() / vectorB.getZ();
        }

        Vector3D rb = multiplicarEscalar(r, vectorB);
        Vector3D diferencia = resta(vectorA, rb);
        return magnitud(diferencia) < 1e-10;
    }

    public boolean paralela(boolean metodo2) {
        Vector3D producto = productoVectorial(vectorA, vectorB);
        return magnitud(producto) < 1e-10;
    }

    public Vector3D proyeccion() {
        double magBCuadrado = magnitud(vectorB) * magnitud(vectorB);
        if (magBCuadrado < 1e-10) {
            throw new IllegalArgumentException("No se puede proyectar sobre un vector cero");
        }

        double escalar = productoEscalar(vectorA, vectorB) / magBCuadrado;
        return multiplicarEscalar(escalar, vectorB);
    }

    public double componente() {
        double magB = magnitud(vectorB);
        if (magB < 1e-10) {
            throw new IllegalArgumentException("No se puede calcular componente sobre un vector cero");
        }

        return productoEscalar(vectorA, vectorB) / magB;
    }

    public Vector3D getVectorA() {
        return vectorA;
    }

    public Vector3D getVectorB() {
        return vectorB;
    }

    public void setVectorA(Vector3D vectorA) {
        this.vectorA = vectorA;
    }

    public void setVectorB(Vector3D vectorB) {
        this.vectorB = vectorB;
    }
}
