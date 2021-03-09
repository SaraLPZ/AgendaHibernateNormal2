package paquetehibernate;

import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	final static int INSERTAR_CONTACTO=1;
	final static int INSERTAR_PRODUCTO=2;
	final static int LISTAR_CONTACTOS=3;
	final static int LISTAR_PRODUCTOS=4;
	final static int BUSCAR_CONTACTOS=5;
	final static int SALIR=6;
	
    static int pedirOpcion() {
        
        System.out.println(INSERTAR_CONTACTO+"-Insertar contacto");
        System.out.println(INSERTAR_PRODUCTO+"-Insertar producto");
        System.out.println(LISTAR_CONTACTOS+"-Listar contactos");
        System.out.println(LISTAR_PRODUCTOS+"-Listar productos");
        System.out.println(BUSCAR_CONTACTOS+"-Buscar contactos");
        System.out.println(SALIR+"-Salir");
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }
    
    static Contacto pedirContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre=sc.nextLine();
        System.out.println("Apellido:");
        String telefono=sc.nextLine();
       Contacto c=new Contacto(nombre, telefono);
        return c;
    }

    static void mostrarContactos(ArrayList<Contacto> lista_contactos) {
        for (Contacto contacto : lista_contactos) {
            System.out.println(contacto);
        }
    }

	public static Producto pedirProducto() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Escribe el nombre del producto");
		String nombre=sc.nextLine();
		System.out.println("Escribe el precio del producto");
		int precio=sc.nextInt();
		Producto p=new Producto(nombre,precio);
		return p;
	}

	public static void mostrarProductos(ArrayList<Producto> lista_productos) {
		for (Producto producto : lista_productos) {
            System.out.println(producto);
        }
	}

	public static String pedirNombreBuscado() {
		System.out.println("Introduzca el nombre del contacto buscado");
		Scanner sc=new Scanner(System.in);
		String nombre=sc.nextLine();
		return nombre;
	}

	public static void mostrarContacto(Contacto contacto_buscado) {
		System.out.println("Nombre: "+contacto_buscado.getNombre());
		System.out.println("Nombre: "+contacto_buscado.getApellido());
	}
}
