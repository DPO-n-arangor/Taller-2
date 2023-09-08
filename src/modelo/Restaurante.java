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
    private double descuentos;

    public Restaurante() {
        ingredientes = new HashMap<>();
        menuBase = new HashMap<>();
        combos = new HashMap<>();
        pedidos = new HashMap<>();

    }

    public void iniciarPedido(String nombreCliente, String direccionCliente) {
        // iniciar pedido con el nombre y la direccion del cliente y almacenarlo en el
        // mapa de pedidos. la llave es el id del pedido y el valor es el pedido. se le
        // pregunta al usuario el pedido que desea hacer tomando en cuenta las opciones
        // del menu
        Pedido pedido = new Pedido(nombreCliente, direccionCliente);
        pedidos.put(pedido.getIdPedido(), pedido);
        System.out.println("Pedido iniciado con el id: " + pedido.getIdPedido());
        System.out.println("Ingrese el nombre del producto que desea agregar al pedido");
        System.out.println("Ingrese 0 para terminar el pedido");
        String producto = input("Ingrese el nombre del producto");
        while (!producto.equals("0")) {
            if (menuBase.containsKey(producto)) {
                pedido.agregarProducto(menuBase.get(producto));
            } else if (combos.containsKey(producto)) {
                pedido.agregarProducto(combos.get(producto));
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
        // mostrar las opciones del menu base de 1 a 22 donde el usuario ingresa el
        // numero del producto que desea en la funcion iniciarPedido
        ArrayList<Producto> menu = new ArrayList<>();
        for (ProductoMenu producto : menuBase.values()) {
            menu.add(producto);
        }
        return menu;

    }

    public ArrayList<Ingrediente> getIngredientes() {
        // TODO
        return null;
    }

    public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
        try {
            // cargar tres archivos siendo ingredientes.txt, menu.txt y combos.txt
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

}
