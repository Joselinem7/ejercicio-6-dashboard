// Ejercicio 6 - Joseline Mazariegos
// Componente del modelo de widgets.
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reloj extends Widget {
    private final String formato;

    public Reloj(int id, String nombre, int memoriaKB, String formato) {
        super(id, nombre, memoriaKB);
        this.formato = formato;
    }

    @Override
    public String renderizar() {
        return "Hora: " + LocalTime.now().format(DateTimeFormatter.ofPattern(formato))
                + " | Formato: " + formato;
    }
}
