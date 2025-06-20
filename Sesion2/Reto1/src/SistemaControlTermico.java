import java.util.concurrent.Callable;


public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000); // Simula balanceo térmico
        return "Control termico: temperatura estable (22°C).";
    }
}
