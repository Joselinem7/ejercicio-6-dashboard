// Ejercicio 6 - Joseline Mazariegos
// Componente del modelo de widgets.
public class Alerta extends Widget implements Interactivo {
    private final String mensaje;
    private boolean leida;

    public Alerta(int id, String nombre, int memoriaKB, String mensaje) {
        super(id, nombre, memoriaKB);
        this.mensaje = mensaje;
        leida = false;
    }

    @Override
    public String renderizar() {
        return mensaje + " | Estado: " + (leida ? "leida" : "pendiente");
    }

    @Override
    public String clic() {
        leida = true;
        return "Alerta marcada como leida.";
    }

    @Override
    public String actualizar() {
        leida = false;
        return "Alerta activada nuevamente.";
    }
}
