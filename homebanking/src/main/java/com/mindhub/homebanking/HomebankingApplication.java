package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,
									  AccountRepository accountRepository) {
		return(args) -> {
			//CLIENTS
			Client client1 = new Client("Misael J.", "López", "misaeljlo91@gmail.com");
			Client client2 = new Client("Emmanuel", "Rolón", "emmanuelrolon250@gmail.com");

			clientRepository.save(client1);
			clientRepository.save(client2);

			//ACCOUNTS
			int minAccount = 100000;
			int maxAccount = 999999;

			int minID = 100;
			int maxID = 999;

			Account account1 = new Account(client1,"VIN-"+(int)((Math.random()*(maxAccount-minAccount+1))+minAccount)+"/"+(int)((Math.random()*(maxID-minID+1))+minID),AccountType.Checking,LocalDateTime.now(),5000);
			Account account2 = new Account(client1,"VIN-"+(int)((Math.random()*(maxAccount-minAccount+1))+minAccount)+"/"+(int)((Math.random()*(maxID-minID+1))+minID),AccountType.Saving,LocalDateTime.now().plusDays(1),7500);
			Account account3 = new Account(client2,"VIN-"+(int)((Math.random()*(maxAccount-minAccount+1))+minAccount)+"/"+(int)((Math.random()*(maxID-minID+1))+minID),AccountType.Saving,LocalDateTime.now(),8000);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
		};
	}
}
