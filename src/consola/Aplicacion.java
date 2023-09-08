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
                } else if (opcionSelenccionada == 2)
                    cargarMenu();
                else if (opcionSelenccionada == 10) {
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
        System.out.println("1. Cargar Menu");
        System.out.println("2. Cargar Pedido");
        System.out.println("3. Cargar Factura");
        System.out.println("4. Salir");
    }

    // private void cargarIngredientes() {

    // }

    private void cargarMenu() {
    }

    public static void main(String[] args) {
        Aplicacion consola = new Aplicacion();
        consola.ejecutarOpcion();
    }
}
