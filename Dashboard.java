// Ejercicio 6 - Joseline Mazariegos
// Modelo: administra el catalogo en memoria.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dashboard {
    // Unica lista: guarda todos los tipos de widgets.
    private final List<Widget> widgets = new ArrayList<>();

    public void agregar(Widget widget) {
        if (widget == null || buscar(widget.getId()) != null) {
            throw new IllegalArgumentException("Widget nulo o ID repetido.");
        }
        widgets.add(widget);
    }

    public int getCantidad() { return widgets.size(); }
    public Widget getWidget(int posicion) { return widgets.get(posicion); }

    // Sobrecarga: se busca por ID o por nombre completo.
    public Widget buscar(int id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) { return widget; }
        }
        return null;
    }

    public Widget buscar(String nombre) {
        for (Widget widget : widgets) {
            if (widget.getNombre().equalsIgnoreCase(nombre.trim())) { return widget; }
        }
        return null;
    }

    public void ordenar() { Collections.sort(widgets); }

    public void cargarCatalogo() {
        if (getCantidad() > 0) { return; }
        agregar(new Clima(1, "Clima Guatemala", 120, "Guatemala", 24));
        agregar(new Clima(2, "Clima Antigua", 100, "Antigua", 21));
        agregar(new Clima(3, "Clima Xela", 110, "Xela", 16));
        agregar(new Reloj(4, "Reloj con segundos", 40, "HH:mm:ss"));
        agregar(new Reloj(5, "Reloj simple", 30, "HH:mm"));
        agregar(new Tareas(6, "Tareas de estudio", 80, 3));
        agregar(new Tareas(7, "Tareas de casa", 70, 2));
        agregar(new Tareas(8, "Tareas del trabajo", 90, 4));
        agregar(new Alerta(9, "Recordatorio", 50, "Revisar el correo"));
        agregar(new Alerta(10, "Reunion", 60, "Reunion a las 10:00"));
    }
}
