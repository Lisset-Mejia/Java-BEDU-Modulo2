import java.util.*;

public class ProcesadorEncuestas {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Ana", "El tiempo de espera fue muy largo", 2),
                        new Encuesta("Luis", null, 5)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Marta", "La atención fue buena, la limpieza puede mejorar", 3),
                        new Encuesta("Pedro", null, 4)
                )),
                new Sucursal("Sur", List.of(
                        new Encuesta("Carlos", null, 2),
                        new Encuesta("Sofía", "No encontre el medicamento que necesitaba", 1)
                ))
        );

        System.out.println("Seguimiento a pacientes insatisfechos:");

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3) // filtra encuestas insatisfechas
                                .map(encuesta -> new Seguimiento(encuesta, sucursal.getNombre())) // combina encuesta + sucursal
                )
                .filter(seg -> seg.encuesta().getComentario().isPresent()) // filtra encuestas con comentario
                .map(seg -> {
                    String comentario = seg.encuesta().getComentario().get();
                    return "Sucursal " + seg.sucursal() +
                            ": Seguimiento a paciente con comentario: \"" + comentario + "\"";
                })
                .forEach(System.out::println);
    }

    record Seguimiento(Encuesta encuesta, String sucursal) {
    }
}
