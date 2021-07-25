package tasks.bankvision.services;

import java.util.Optional;

/**
 * Esta interface establece los metodos basicos para la crud de la clase usuario
 * @author Diian_Ramirez
 *
 */

import tasks.bankvision.entities.User;

public interface UserService {
	public Iterable<User> findAll();
	public Optional<User> findById(Long id);
	public User save(User employee);
	public void deleteById(Long id);
}