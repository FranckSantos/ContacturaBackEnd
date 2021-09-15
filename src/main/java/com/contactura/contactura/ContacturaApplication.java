package com.contactura.contactura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContacturaApplication.class, args);
	}
	/*
	 * @Bean CommandLineRunner init(ContacturaRepository repository) { return args
	 * -> { //para o caso de ser necessario limpar o ba nco //repository.deleteAll();
	 * LongStream.range(1, 100) .mapToObj(id -> { Contactura c = new Contactura();
	 * c.setName("Contactura User" + id); c.setPhone("(081) 9" + id + id + id + id +
	 * '-' + id + id + id + id); c.setEmail("contactura_user" + id +
	 * "@contactura.com"); return c; }).map(record -> repository.save(record))
	 * .forEach(System.out::println); }; }
	 */
}
