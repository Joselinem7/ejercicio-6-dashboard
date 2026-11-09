// Comprobaciones del modelo, sin librerias adicionales ni salida de consola.
public class PruebaDashboard {
    private static void verificar(boolean condicion) {
        if (!condicion) { throw new AssertionError("Fallo una comprobacion"); }
    }

    public static void main(String[] args) {
        Dashboard d = new Dashboard();
        d.cargarCatalogo();
        verificar(d.getCantidad() == 10);
        d.cargarCatalogo();
        verificar(d.getCantidad() == 10);
        verificar(d.buscar(1) == d.buscar(" clima GUATEMALA "));
        verificar(d.buscar(999) == null && d.buscar("inexistente") == null);
        d.ordenar();
        for (int i = 1; i < d.getCantidad(); i++) {
            verificar(d.getWidget(i - 1).getMemoriaKB() <= d.getWidget(i).getMemoriaKB());
        }
        Controlador c = new Controlador(d);
        verificar(c.hacerClic(1).contains("informativo"));
        verificar(c.hacerClic(999).contains("No se encontro"));
        c.hacerClic(6);
        verificar(d.buscar(6).renderizar().contains("2"));
        c.hacerClic(9);
        verificar(d.buscar(9).renderizar().contains("leida"));
        c.actualizarTodos();
        verificar(d.buscar(6).renderizar().contains("3"));
        verificar(d.buscar(9).renderizar().contains("pendiente"));
        c.hacerClic(7); c.hacerClic(7); c.hacerClic(7);
        verificar(c.hacerClic(7).equals("No hay tareas pendientes."));
        // Un nuevo tipo se agrega al modelo sin cambiar el controlador.
        d.agregar(new Widget(11, "Nota", 10) {
            @Override public String renderizar() { return "Nueva nota"; }
        });
        verificar(c.listar().contains("Nueva nota"));
        try {
            d.agregar(new Clima(1, "Duplicado", 10, "Ciudad", 20));
            throw new AssertionError("Acepto un ID duplicado");
        } catch (IllegalArgumentException e) {
            verificar(d.getCantidad() == 11);
        }
    }
}
