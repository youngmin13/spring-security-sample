package com.example.memo.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String email;
	@Setter
	private String name;
	private LocalDateTime createdAt;
}
