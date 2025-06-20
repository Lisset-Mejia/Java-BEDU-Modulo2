import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Calculando ruta...");
                TimeUnit.SECONDS.sleep(2 + ThreadLocalRandom.current().nextInt(2));
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error al calcular ruta", e);
            }
            return "Centro -> Norte";
        });
    }

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Estimando tarifa...");
                TimeUnit.SECONDS.sleep(1 + ThreadLocalRandom.current().nextInt(2));
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error al estimar tarifa", e);
            }
            return 75.50;
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) ->
                        String.format("Ruta calculada: %s | Tarifa estimada: $%.2f", ruta, tarifa)
                ).exceptionally(error -> "Error en el procesamiento: " + error.getMessage())
                .thenAccept(System.out::println);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}