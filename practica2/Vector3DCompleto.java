package Practica2;

class Vector3DCompleto {
    private double x, y, z;

    public Vector3DCompleto() {
        this(0, 0, 0);
    }

    public Vector3DCompleto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3DCompleto(Vector3DCompleto v) {
        this(v.x, v.y, v.z);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    public Vector3DCompleto suma(Vector3DCompleto b) {
        return new Vector3DCompleto(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    public Vector3DCompleto suma(double bx, double by, double bz) {
        return new Vector3DCompleto(this.x + bx, this.y + by, this.z + bz);
    }

    public Vector3DCompleto multiplicar(double r) {
        return new Vector3DCompleto(r * this.x, r * this.y, r * this.z);
    }

    public static Vector3DCompleto multiplicar(double r, Vector3DCompleto a) {
        return new Vector3DCompleto(r * a.x, r * a.y, r * a.z);
    }

    public double longitud() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double longitud(Vector3DCompleto a) {
        return a.longitud();
    }

    public Vector3DCompleto normalizar() {
        double mag = longitud();
        if (mag < 1e-10) {
            throw new IllegalArgumentException("No se puede normalizar un vector cero");
        }
        return new Vector3DCompleto(x / mag, y / mag, z / mag);
    }

    public static Vector3DCompleto normalizar(Vector3DCompleto a) {
        return a.normalizar();
    }

    public double productoEscalar(Vector3DCompleto b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    public double productoEscalar(double bx, double by, double bz) {
        return this.x * bx + this.y * by + this.z * bz;
    }

    public static double productoEscalar(Vector3DCompleto a, Vector3DCompleto b) {
        return a.productoEscalar(b);
    }

    public Vector3DCompleto productoVectorial(Vector3DCompleto b) {
        double newX = this.y * b.z - this.z * b.y;
        double newY = this.z * b.x - this.x * b.z;
        double newZ = this.x * b.y - this.y * b.x;
        return new Vector3DCompleto(newX, newY, newZ);
    }

    public Vector3DCompleto productoVectorial(double bx, double by, double bz) {
        double newX = this.y * bz - this.z * by;
        double newY = this.z * bx - this.x * bz;
        double newZ = this.x * by - this.y * bx;
        return new Vector3DCompleto(newX, newY, newZ);
    }

    public static Vector3DCompleto productoVectorial(Vector3DCompleto a, Vector3DCompleto b) {
        return a.productoVectorial(b);
    }

    public Vector3DCompleto restar(Vector3DCompleto b) {
        return new Vector3DCompleto(this.x - b.x, this.y - b.y, this.z - b.z);
    }

    public boolean esCero() {
        return Math.abs(x) < 1e-10 && Math.abs(y) < 1e-10 && Math.abs(z) < 1e-10;
    }

    public boolean equals(Vector3DCompleto v) {
        return Math.abs(this.x - v.x) < 1e-10 &&
               Math.abs(this.y - v.y) < 1e-10 &&
               Math.abs(this.z - v.z) < 1e-10;
    }

    @Override
    public String toString() {
        return String.format("(%.3f, %.3f, %.3f)", x, y, z);
    }
}
