import java.util.List;
import java.util.Optional;


public class ConfirmarPedidos {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Ana", "domicilio", "555-1234"),
                new Pedido("Luis", "local", null),
                new Pedido("Sofia", "domicilio", "555-5678"),
                new Pedido("Carlos", "domicilio", null)
        );

        pedidos.stream()
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                .map(telefono -> "Confirmacion enviada al número: " + telefono)
                .forEach(System.out::println);
    }
}
