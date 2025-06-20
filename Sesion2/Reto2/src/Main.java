import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Simula el acceso a un recurso medico de multiples profesionales.
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando acceso a la Sala de cirugia...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugia");

        List<String> profesionales = List.of(
                "Dra. Sanchez", "Dr. Gomez", "Enfermera Lopez", "Dr. Ruiz", "Dra. Torres"
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String profesional : profesionales) {
            executor.submit(() -> salaCirugia.usar(profesional));
        }

        executor.shutdown();
    }
}