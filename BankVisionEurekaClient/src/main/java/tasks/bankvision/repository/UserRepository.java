package tasks.bankvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tasks.bankvision.entities.User;

/**
 * el repositorio establece el medio para alojar los datos ya que se conecta con la base de datos
 * la conexion con la base de datos se establece en el application.properties del proyecto
 * @author Diian_Ramirez
 *
 */

public interface UserRepository extends JpaRepository<User, Long>{
	
}