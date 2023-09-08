package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Producto;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;
import modelo.Restaurante;

public class Aplicacion {
    private Restaurante info;

    public void ejecutarOpcion() {
        System.out.println("Restaurante de Hamburguesas");

        boolean continuar = true;
        while (continuar) {
            try {
                mostrarMenu();
                int opcionSelenccionada = Integer.parseInt(input("Seleccione una opción"));
                info = new Restaurante();
                if (opcionSelenccionada == 1) {
                    File combos = new File("./data/combos.txt");
                    File menu = new File("./data/menu.txt");
                    File ingredientes = new File("./data/ingredientes.txt");
                    info.cargarInformacionRestaurante(ingredientes, menu, combos);
                    System.out.println("Información cargada correctamente");
                } else if (opcionSelenccionada == 2)
                    info.getMenuBase();
                else if (opcionSelenccionada == 3)
                    info.iniciarPedido(input("Ingrese el nombre del cliente"),
                            input("Ingrese la dirección del cliente"));
                else if (opcionSelenccionada == 4)
                    info.getPedidoEnCurso();
                else if (opcionSelenccionada == 5)
                    info.cerrarYGuardarPedido();
                else if (opcionSelenccionada == 6) {
                    continuar = false;
                    System.out.println("Gracias por usar la aplicación...");
                } else {
                    System.out.println("Por favor seleccione una opción válida.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Debe ingresar un número de las opciones");
            }
        }
    }

    private String input(String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error leyendo de la consola");
            e.printStackTrace();
        }
        return null;
    }

    public void mostrarMenu() {
        System.out.println("1. Cargar datos restaurante");
        System.out.println("2. Mostrar menú");
        System.out.println("3. Iniciar nuevo pedido");
        System.out.println("4. Agregar elemento a un pedido");
        System.out.println("5. Cerrar pedido y guardar factura");
        System.out.println("6. Salir");
    }

    public static void main(String[] args) {
        Aplicacion consola = new Aplicacion();
        consola.ejecutarOpcion();
    }
}
