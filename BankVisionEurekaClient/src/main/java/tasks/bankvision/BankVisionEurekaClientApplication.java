package tasks.bankvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Esta clase proporciona la ejecucuión del microservicio de usuarios que
 * se alojara en el servidor eureka
 * EnableEurekaClient permite definir que este será el cliente
 * @author Diian_Ramirez
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class BankVisionEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankVisionEurekaClientApplication.class, args);
	}

}
