package com.example.memo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemoRepository {
	private final JdbcTemplate jdbcTemplate;

	public MemoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// TODO : Move some of controller logic to repository layer (data access)
}
