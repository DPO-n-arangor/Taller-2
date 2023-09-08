package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.Producto;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;
import modelo.Restaurante;

public class Aplicacion {
    private Restaurante info;
    private Pedido pedido;

    public void ejecutarOpcion() {
        System.out.println("\n* Restaurante de Hamburguesas *");
        info = new Restaurante();
        boolean continuar = true;
        while (continuar) {
            try {
                mostrarMenu();
                int opcionSelenccionada = Integer.parseInt(input("Seleccione una opción"));
                if (opcionSelenccionada == 1) {
                    File combos = new File("./data/combos.txt");
                    File menu = new File("./data/menu.txt");
                    File ingredientes = new File("./data/ingredientes.txt");
                    info.cargarInformacionRestaurante(ingredientes, menu, combos);
                    System.out.println("\n* Información cargada correctamente *\n");
                } else if (opcionSelenccionada == 2) {
                    info.getMenuBase();
                    System.out.println("---------------------------\n");
                } else if (opcionSelenccionada == 3)
                    info.iniciarPedido(input("Ingrese el nombre del cliente"),
                            input("Ingrese la dirección del cliente"));
                else if (opcionSelenccionada == 4)
                    info.cargarInformacionRestaurante(null, null, null);
                else if (opcionSelenccionada == 5)
                    info.cerrarYGuardarPedido();
                else if (opcionSelenccionada == 6)
                    pedido.getIdPedido();
                else if (opcionSelenccionada == 0) {
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
        System.out.println("\n1. Cargar datos restaurante");
        System.out.println("2. Mostrar menú");
        System.out.println("3. Iniciar nuevo pedido");
        System.out.println("4. Agregar elemento a un pedido");
        System.out.println("5. Cerrar pedido y guardar factura");
        System.out.println("6. Consultar la información de un pedido por id");
        System.out.println("0. Salir\n");
    }

    public static void main(String[] args) {
        Aplicacion consola = new Aplicacion();
        consola.ejecutarOpcion();
    }
}
