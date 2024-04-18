package net.javaguide.bankingapp;

import net.javaguide.bankingapp.entities.Account;
import net.javaguide.bankingapp.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
@Bean
	public CommandLineRunner start(AccountRepository accountRepository){
		return args -> {
			//accountRepository.save(Account.builder().accountHolderName("Mouhamadou").balance(10000).build());
		};
}
}
