package br.com.dio.warehouse;

import br.com.dio.warehouse.config.RabbitmqQueueProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RabbitmqQueueProperties.class)
public class WarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

}
