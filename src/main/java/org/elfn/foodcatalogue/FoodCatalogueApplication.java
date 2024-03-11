package org.elfn.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCatalogueApplication.class, args);
	}

	// Cette annotation indique à Spring qu'il s'agit d'une méthode qui produit un bean qui sera géré par le contexte Spring.
	@Bean
    // Cette annotation configure le RestTemplate pour utiliser Ribbon pour le load balancing entre instances de services.
	@LoadBalanced
    // Méthode pour créer et retourner une instance de RestTemplate.
    // RestTemplate est utilisé pour faire des appels HTTP entre microservices.
	public RestTemplate getRestTemplate(){
		// Crée une nouvelle instance de RestTemplate.
		return new RestTemplate();
	}


}
