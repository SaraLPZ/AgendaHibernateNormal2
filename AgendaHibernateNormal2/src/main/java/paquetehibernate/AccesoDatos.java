package paquetehibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoDatos {
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
public static void inicializarBD(){
	 s=new StandardServiceRegistryBuilder().configure().build();
	   sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	   
	}

	static void insertarContacto(Contacto c) {
		 Session sesion=sf.openSession();
		 Transaction t=sesion.beginTransaction();
		 sesion.save(c);
		 t.commit();
	}
	
	public static void insertarProducto(Producto p) {
		Session sesion=sf.openSession();
		 Transaction t=sesion.beginTransaction();
		 sesion.save(p);
		 t.commit();
	}
	
	static ArrayList<Contacto> recuperarContactos(String nombre_buscado) {
	       
    	Session s=sf.openSession();
    	Query q=s.createQuery("FROM Contacto");
    	List lista_contactos= q.getResultList();
    	
        return (ArrayList)lista_contactos;
    }

	public static ArrayList<Producto> recuperarProductos(String nombre_buscado) {
		Session s=sf.openSession();
    	Query q=s.createQuery("FROM Producto");
    	List lista_productos= q.getResultList();
    	
        return (ArrayList)lista_productos;
	}

	public static Contacto recuperarContactoPorNombre(String nombre_buscado) {
		Session s=sf.openSession();
		Query consulta=s.createQuery("FROM Contacto WHERE nombre='"+nombre_buscado+"'");
		Contacto c=(Contacto)consulta.getSingleResult();
		return c;
	}

	
}
