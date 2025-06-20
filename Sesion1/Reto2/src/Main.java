import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>(List.of(
                new Video("Introduccion a Java", "Mario", 15),
                new Video("POO en Java", "Carlos", 20),
                new Articulo("Historia de Java", "Ana", 1200),
                new Articulo("Tipos de datos", "Luis", 800),
                new Ejercicio("Variables y tipos", "Luis", false),
                new Ejercicio("Condicionales", "Mario", false)
        ));

        System.out.println("Materiales:");
        GestorMateriales.mostrarMateriales(materiales);
        System.out.println();

        System.out.println("Duración de videos:");
        GestorMateriales.contarDuracionVideos(
                materiales.stream().filter(Video.class::isInstance).map(Video.class::cast).toList()
        );
        System.out.println();

        System.out.println("Marcando ejercicios como revisados...");
        GestorMateriales.marcarEjerciciosRevisados(materiales);
        System.out.println();

        System.out.println("Filtrando materiales por autor (Mario):");
        GestorMateriales.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}