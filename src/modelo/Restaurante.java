package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
    private HashMap<String, Ingrediente> ingredientes;
    private HashMap<String, ProductoMenu> menuBase;
    private HashMap<String, Combo> combos;
    private HashMap<Integer, Pedido> pedidos;

    public Restaurante() {
        ingredientes = new HashMap<>();
        menuBase = new HashMap<>();
        combos = new HashMap<>();
        pedidos = new HashMap<>();

    }

    public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
        try {
            cargarIngredientes(archivoIngredientes);
            cargarMenu(archivoMenu);
            cargarCombos(archivoCombos);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void cargarIngredientes(File archivoIngredientes) {

        try (BufferedReader lector = new BufferedReader(new FileReader((archivoIngredientes)))) {
            String linea = lector.readLine();

            while (linea != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String costoString = datos[1].trim();
                int costo = Integer.parseInt(costoString);
                Ingrediente ingrediente0 = new Ingrediente(nombre, costo);
                ingredientes.put(nombre, ingrediente0);
                linea = lector.readLine();
            }
            System.out.print("\nSe cargaron " + ingredientes.size() + " ingredientes, ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarMenu(File archivoMenu) {
        try {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoMenu))) {
                String linea = lector.readLine();

                while (linea != null) {
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    String precioString = datos[1].trim();
                    int precioBase = Integer.parseInt(precioString);
                    ProductoMenu precio = new ProductoMenu(nombre, precioBase);
                    menuBase.put(nombre, precio);
                    linea = lector.readLine();
                }
                System.out.print(menuBase.size() + " productos de menú");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarCombos(File archivoCombos) {
        try {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoCombos))) {
                String linea = lector.readLine();

                while (linea != null) {
                    String[] datos = linea.split(";");
                    String nombre = datos[0].trim();
                    String descuentoString = datos[1].replace("%", "");
                    int descuentoDouble = Integer.parseInt(descuentoString);
                    Combo combitos = new Combo(nombre, descuentoDouble);
                    combos.put(nombre, combitos);
                    linea = lector.readLine();
                }
                System.out.println(" y " + combos.size() + " combos!");
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public void iniciarPedido(String nombreCliente, String direccionCliente) {
        Pedido pedido = new Pedido(nombreCliente, direccionCliente);
        pedidos.put(pedido.getIdPedido(), pedido);
        System.out.println("Pedido iniciado con el id: " + pedido.getIdPedido());
        System.out.println("Ingrese el nombre del producto que desea agregar al pedido");
        String producto = input("Ingrese el nombre del producto o 0 para terminar el pedido");
        while (!producto.equals("0")) {
            if (menuBase.containsKey(producto)) {
                pedido.agregarProducto(menuBase.get(producto));
            } else {
                System.out.println("El producto ingresado no existe");
            }
            producto = input("Ingrese el nombre del producto");
        }
        System.out.println("Pedido terminado");

    }

    public void cerrarYGuardarPedido() {
        // TODO

    }

    public Pedido getPedidoEnCurso() {
        // TODO
        return null;
    }

    public ArrayList<Producto> getMenuBase() {
        ArrayList<Producto> opciones = new ArrayList<>();
        for (String i : menuBase.keySet()) {
            opciones.add(menuBase.get(i));
        }
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i).getNombre());
        }
        return opciones;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        ArrayList<Ingrediente> opciones = new ArrayList<>();
        for (String i : ingredientes.keySet()) {
            opciones.add(ingredientes.get(i));
        }
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i).getNombre());
        }
        return opciones;
    }

    public ArrayList<Combo> getCombos() {
        ArrayList<Combo> opciones = new ArrayList<>();
        for (String i : combos.keySet()) {
            opciones.add(combos.get(i));
        }
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i).getNombre());
        }
        return opciones;
    }

}
