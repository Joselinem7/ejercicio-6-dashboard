// Ejercicio 6 - Joseline Mazariegos
// Componente del modelo de widgets.
public class Tareas extends Widget implements Interactivo {
    private int pendientes;

    public Tareas(int id, String nombre, int memoriaKB, int pendientes) {
        super(id, nombre, memoriaKB);
        this.pendientes = pendientes;
    }

    @Override
    public String renderizar() { return "Tareas pendientes: " + pendientes; }

    @Override
    public String clic() {
        if (pendientes == 0) { return "No hay tareas pendientes."; }
        pendientes--;
        return "Se completo una tarea. " + renderizar();
    }

    @Override
    public String actualizar() {
        pendientes++;
        return "Se agrego una tarea de ejemplo. " + renderizar();
    }
}
