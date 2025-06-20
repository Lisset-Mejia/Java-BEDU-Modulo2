import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Simulación de mision espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Lista de tareas a ejecutar
        List<Callable<String>> sistemas = List.of(
                new SistemaNavegacion(),
                new SistemaSoporteVital(),
                new SistemaControlTermico(),
                new SistemaComunicaciones()
        );

        // Ejecutar y recolectar resultados
        List<Future<String>> resultados = executor.invokeAll(sistemas);

        for (Future<String> resultado : resultados) {
            System.out.println(resultado.get());
        }

        executor.shutdown();

        System.out.println("Todos los sistemas reportan estado operativo.");
    }
}