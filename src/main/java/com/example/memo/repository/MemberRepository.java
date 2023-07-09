package com.example.memo.repository;

import com.example.memo.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

	Member findByEmail(String email);
}
