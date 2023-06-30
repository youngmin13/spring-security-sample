package com.example.memo;

import com.example.memo.domain.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersistenceContextTest {
	@Test
	@DisplayName("Persistence Context Save Test")
	void persistenceContextSaveTest() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("memo");

		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			User user = new User("user@gmail.com", "user", LocalDateTime.now()); // 응용 프로그램
			manager.persist(user); // 영속 컨텍스트
			transaction.commit(); // DB
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			manager.close();
		}

		emf.close();
	}

	@Test
	@DisplayName("Persistence Context Update Test")
	void persistenceContextUpdateTest() {
		// TODO : Implement persistence context update sample code
	}
}
