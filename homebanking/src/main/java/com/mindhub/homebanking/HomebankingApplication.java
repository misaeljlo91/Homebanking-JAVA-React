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
									  AccountRepository accountRepository,
									  TransactionRepository transactionRepository) {
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

			//TRANSACTIONS
			int minDescription = 100000;
			int maxDescription = 999999;

			int minIdDescription = 100;
			int maxIdDescription = 999;

			Transaction transaction1 = new Transaction(account1, account1.getHolder(), account1.getNumber(), TransactionType.Debit,400,"Purchase","D"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account2.getHolder(), account2.getNumber(),3900, LocalDateTime.now().minusDays(2).minusHours(3));
			Transaction transaction2 = new Transaction(account1, account1.getHolder(), account1.getNumber(), TransactionType.Credit,600,"Deposit","C"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account3.getHolder(), account3.getNumber(),4500, LocalDateTime.now().minusDays(1));
			Transaction transaction3 = new Transaction(account1, account1.getHolder(), account1.getNumber(), TransactionType.Credit,500,"Deposit","C"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account2.getHolder(), account2.getNumber(),5000, LocalDateTime.now());
			Transaction transaction4 = new Transaction(account2, account2.getHolder(), account2.getNumber(), TransactionType.Credit,1000,"Deposit","C"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account1.getHolder(), account1.getNumber(),8400, LocalDateTime.now().minusDays(3).minusHours(8));
			Transaction transaction5 = new Transaction(account2, account2.getHolder(), account2.getNumber(), TransactionType.Debit,300,"Purchase","D"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account3.getHolder(), account3.getNumber(),8100, LocalDateTime.now().minusHours(6));
			Transaction transaction6 = new Transaction(account2, account2.getHolder(), account2.getNumber(), TransactionType.Debit,600,"Withdrawal","D"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account1.getHolder(), account1.getNumber(),7500, LocalDateTime.now());
			Transaction transaction7 = new Transaction(account3, account3.getHolder(), account3.getNumber(), TransactionType.Debit,800,"Transfer","D"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account1.getHolder(), account1.getNumber(),7200, LocalDateTime.now().minusDays(5).minusHours(2));
			Transaction transaction8 = new Transaction(account3, account3.getHolder(), account3.getNumber(), TransactionType.Debit,200,"Purchase","D"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account2.getHolder(), account2.getNumber(),7000, LocalDateTime.now().minusDays(2).minusHours(4));
			Transaction transaction9 = new Transaction(account3, account3.getHolder(), account3.getNumber(), TransactionType.Credit,1000,"Transfer","C"+(int)((Math.random()*(maxDescription-minDescription+1))+minDescription)+"/"+(int)((Math.random()*(maxIdDescription-minIdDescription+1))+minIdDescription), account2.getHolder(), account2.getNumber(),8000, LocalDateTime.now());

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);
			transactionRepository.save(transaction5);
			transactionRepository.save(transaction6);
			transactionRepository.save(transaction7);
			transactionRepository.save(transaction8);
			transactionRepository.save(transaction9);
		};
	}
}
