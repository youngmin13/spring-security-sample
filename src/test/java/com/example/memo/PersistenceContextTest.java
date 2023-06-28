package com.example.memo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersistenceContextTest {
	@Test
	@DisplayName("Persistence Context Default Test")
	void persistenceContextDefaultTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("memo");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();


	}
}
