// Ejercicio 6 - Joseline Mazariegos
// Componente del modelo de widgets.
public class Clima extends Widget {
    private final String ciudad;
    private final int temperatura;

    public Clima(int id, String nombre, int memoriaKB, String ciudad, int temperatura) {
        super(id, nombre, memoriaKB);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    @Override
    public String renderizar() {
        return "Clima en " + ciudad + ": " + temperatura + " grados C (dato de ejemplo)";
    }
}
