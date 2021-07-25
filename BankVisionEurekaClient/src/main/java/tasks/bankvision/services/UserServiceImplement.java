package tasks.bankvision.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tasks.bankvision.entities.User;
import tasks.bankvision.repository.UserRepository;

/**
 * Esta clase implementa la interfaz con lso metodos que haras parte de la crud de Usuario
 * se implementa cada metodo usando el repositorio para acceder a las operaciones sobre datos
 * Se hace una inyección de dependencia al repsitorio que servirá para llegar a la base de datos
 * @author Diian_Ramirez
 *
 */
@Service
public class UserServiceImplement  implements UserService{
	
	@Autowired
	private UserRepository employeeRepository;

	@Override
	public Iterable<User> findAll() {
		return (List<User>) employeeRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public User save(User employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
}