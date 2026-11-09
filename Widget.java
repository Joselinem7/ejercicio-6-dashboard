// Ejercicio 6 - Joseline Mazariegos
// Componente del modelo de widgets.
public abstract class Widget implements Renderizable, Comparable<Widget> {
    private final int id;
    private final String nombre;
    private final int memoriaKB;

    public Widget(int id, String nombre, int memoriaKB) {
        if (id <= 0 || nombre == null || nombre.trim().isEmpty() || memoriaKB < 0) {
            throw new IllegalArgumentException("Datos de widget invalidos.");
        }
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    @Override
    public int compareTo(Widget otro) {
        return Integer.compare(memoriaKB, otro.memoriaKB);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " | " + memoriaKB + " KB";
    }
}
