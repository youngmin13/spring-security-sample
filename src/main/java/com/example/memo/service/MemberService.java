package com.example.memo.service;

import com.example.memo.configuration.security.JwtUtil;
import com.example.memo.domain.entity.Member;
import com.example.memo.domain.model.AuthorizedMember;
import com.example.memo.dto.LoginRequest;
import com.example.memo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email);
		if (member == null) {
			throw new UsernameNotFoundException(email);
		}
		return new AuthorizedMember(member);
	}

	public String login(LoginRequest loginRequest) {
		Member member = memberRepository.findByEmail(loginRequest.email());
		if (member == null) {
			throw new UsernameNotFoundException(loginRequest.email());
		}

		if (!passwordEncoder.matches(loginRequest.password(), member.getPassword())) {
			throw new BadCredentialsException("잘못된 요청입니다. 아이디 또는 비밀번호를 확인해주세요.");
		}

		return JwtUtil.createToken(loginRequest.email());
	}
}
