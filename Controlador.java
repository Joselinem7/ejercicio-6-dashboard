// Ejercicio 6 - Joseline Mazariegos
// Conecta el modelo con la vista.
public class Controlador {
    private final Dashboard dashboard;

    public Controlador(Dashboard dashboard) { this.dashboard = dashboard; }

    // El parametro interfaz permite renderizar cualquier implementacion.
    public String mostrar(Renderizable elemento) { return elemento.renderizar(); }

    public String listar() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < dashboard.getCantidad(); i++) {
            Widget widget = dashboard.getWidget(i);
            texto.append(widget).append("\n  ").append(mostrar(widget)).append("\n");
        }
        return texto.toString();
    }

    public String buscar(int id) { return detalle(dashboard.buscar(id)); }
    public String buscar(String nombre) { return detalle(dashboard.buscar(nombre)); }

    private String detalle(Widget widget) {
        if (widget == null) { return "No se encontro el widget."; }
        return widget + "\nTipo: " + widget.getClass().getSimpleName()
                + "\nInteractivo: " + (widget instanceof Interactivo ? "si" : "no")
                + "\n" + mostrar(widget);
    }

    public String ordenar() {
        dashboard.ordenar();
        return "Ordenados de menor a mayor memoria:\n" + listar();
    }

    public String hacerClic(int id) {
        Widget widget = dashboard.buscar(id);
        if (widget == null) { return "No se encontro el widget."; }
        if (widget instanceof Interactivo) { return hacerClic((Interactivo) widget); }
        return "Este widget es informativo y no admite clics.";
    }

    // Otra sobrecarga: ID para la vista e interfaz para ejecutar el comportamiento.
    public String hacerClic(Interactivo elemento) { return elemento.clic(); }
    public String actualizar(Interactivo elemento) { return elemento.actualizar(); }

    public String actualizarTodos() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < dashboard.getCantidad(); i++) {
            Widget widget = dashboard.getWidget(i);
            if (widget instanceof Interactivo) {
                texto.append(widget.getNombre()).append(": ")
                        .append(actualizar((Interactivo) widget)).append("\n");
            }
        }
        return texto.toString();
    }
}
