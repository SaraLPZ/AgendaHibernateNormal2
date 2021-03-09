package paquetehibernate;

import java.util.ArrayList;

public class ClasePrincipal {
	public static void main(String[] args) {
		int opcion=EntradaSalida.pedirOpcion();
        AccesoDatos.inicializarBD();
        while(opcion!=EntradaSalida.SALIR)
        {
            switch(opcion)
            {
                case EntradaSalida.INSERTAR_CONTACTO:
                    Contacto c=EntradaSalida.pedirContacto();
                    AccesoDatos.insertarContacto(c);
                    break;
                case EntradaSalida.INSERTAR_PRODUCTO:
                    Producto p=EntradaSalida.pedirProducto();
                    AccesoDatos.insertarProducto(p);
                    break;
                case EntradaSalida.LISTAR_CONTACTOS:
                    ArrayList<Contacto> lista_contactos=AccesoDatos.recuperarContactos("");
                    EntradaSalida.mostrarContactos(lista_contactos);
                    break;
                case EntradaSalida.LISTAR_PRODUCTOS:
                    ArrayList<Producto> lista_productos=AccesoDatos.recuperarProductos("");
                    EntradaSalida.mostrarProductos(lista_productos);
                    break;
                case EntradaSalida.BUSCAR_CONTACTOS:
                    String nombre_buscado=EntradaSalida.pedirNombreBuscado();
                    Contacto contacto_buscado=AccesoDatos.recuperarContactoPorNombre(nombre_buscado);
                    EntradaSalida.mostrarContacto(contacto_buscado);
                    break;
            }
            opcion=EntradaSalida.pedirOpcion();
        }
	}
}
