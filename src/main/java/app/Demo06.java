package app;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.EquipoDental;

public class Demo06 {

	public static void main(String[] args) {
		// Establecemos conexión con la base de datos
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos un manager
		EntityManager manager = factory.createEntityManager();

		// Iniciamos proceso
		try {
			String jpql = "select e from EquipoDental e";
			
			List<EquipoDental> lstEquipoDental = manager.createQuery(jpql, EquipoDental.class).getResultList();
			
			StringBuilder sb = new StringBuilder();
			sb.append("LISTADO DE Equipo Dental:\n");
						
			for (EquipoDental e : lstEquipoDental) {	
				
				sb.append("Nro Equipo.......: " + e.getNroEquipo() + "\n");
				sb.append("Nombre......: " + e.getNombre() + "\n");
				sb.append("Costo..........: " + e.getCosto() + "\n");
				sb.append("Fecha Adquisicion........: " + e.getFechaAdquisicion() + "\n");
				sb.append("Dentista........: " + e.getDentista() + "\n");
				sb.append("Correo...........: " + e.getDentista().getCorreo() + "\n");
				sb.append("Especialidad.....: " + e.getDentista().getEspecialidad()+ "\n");
				sb.append("Estado..............: " + e.getEstado()+ "\n");
				sb.append("---------------------------------\n\n");
			}
			
			System.out.println(sb);

		} catch (Exception e) {
			System.out.println("Hubo un error en la transacción");
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
	}

}
