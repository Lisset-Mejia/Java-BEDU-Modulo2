import java.util.concurrent.Callable;


public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1200); // Simula el cálculo de trayectoria
        return "Navegacion: trayectoria corregida con exito!";
    }
}
