package com.om.redis;

import com.om.redis.entity.Address;
import com.om.redis.entity.Person;
import com.om.redis.repository.PersonRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

@SpringBootApplication
@EnableSwagger2
@EnableRedisDocumentRepositories(basePackages = "com.om.redis.*")
public class SpringOmRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOmRedisApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	CommandLineRunner loadDataTest(PersonRepository repo) {
		return args -> {
			repo.deleteAll();

			String thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You.";

			// Serendipity, 248 Seven Mile Beach Rd, Broken Head NSW 2481, Australia
			Address thorsAddress = Address.of("248", "Tan Lap", "HCM  city", "Thu Duc", "2481", "Viet Nam");

			Person person = Person.of("Hung", "Nguyen", 38, thorSays, new Point(153.616667, -28.716667), thorsAddress ,Set.of("hammer", "biceps", "hair", "heart"));

			repo.save(person);
		};
	}



}
