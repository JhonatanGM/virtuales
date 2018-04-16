package pe.edu.cibertec.proyemp.jpa.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Testeo {
	private EntityManager manager;

	public Testeo(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Actividad1");

		EntityManager em = factory.createEntityManager();

		Testeo jpa = new Testeo(em);

		EntityTransaction et = em.getTransaction();

		et.begin();

			jpa.crearProyectoDesdeUnEmpleado();
		et.commit();

	}

	private void crearProyectoDesdeUnEmpleado() {
		Empleado emp1 = manager.find(Empleado.class, new Long(1));
		
		Proyecto proy1 = new Proyecto("Market Place");
		Proyecto proy2 = new Proyecto("e-commerce");
		
		List<Proyecto> proyectos = Arrays.asList(proy1,proy2);
		
		emp1.setProyectos(proyectos);
		manager.persist(emp1);


	}

}
