package tasks.bankvision.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tasks.bankvision.entities.User;
import tasks.bankvision.services.UserService;

@CrossOrigin(origins="http://localhost:4200") 
@RestController
@RequestMapping("/users")

/**
 * Esta clase permite definir el RestController de la app, donde se establecen las rutas de los diferentes servicis
 * los rest incluyen GET POST DELETE PUT
 * Se inyecta la dependencia al servicio de usuarios mediante Autowired
 * el requestmapping corresponde a la ruta luego de definir el host y puerto
 * @author Diian_Ramirez
 *
 */
public class UserController {
	
	@Autowired
	private UserService employeeService;
	
	@GetMapping("/viewall")
	public ResponseEntity<?> viewAll(){
		return ResponseEntity.ok().body(employeeService.findAll());
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<?> viewOne(@PathVariable Long id){
		Optional<User> Employee = employeeService.findById(id);
		if(Employee != null) {
			return ResponseEntity.status(HttpStatus.OK).body(Employee);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<User> Employee = employeeService.findById(id);
		employeeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Employee);
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> create(@RequestBody User Employee){
		User employee = employeeService.save(Employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody User Employee ){
		Optional<User> employee = employeeService.findById(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}else {
			employee.get().setName(Employee.getName());
			employee.get().setLastName(Employee.getLastName());
			employee.get().setPhone(Employee.getPhone());
			employeeService.save(employee.get());
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		}
	}
}