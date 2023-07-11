# Spring security 과제

## Level 1

* ### MemberController.getMemberInfo(...) 개선

custom annotation을 활용해서 authorizedMember.getMember()와 같이 중복 개념(member에서 member 접근)을 제거하고 한번에 member를 가져오는 방식으로 개선합니다.

* ### JwtAuthenticationFilter.successfulAuthentication() 구현

올바른 인증 요청에 대한 결과로 jwt token 만들고, 검증한 후에 201 response로 해당 token을 Response body에 세팅합니다.

* ### JwtAuthorizationFilter 구현

요청에 들어온 JWT를 parsing해서 "ROLE_MEMBER" 권한이 있는지 확인하고, SecurityContextHolder에 context 설정합니다.
이후 POST /api/members api로 로그인한 jwt token으로 GET /api/members api를 요청했을 때 제대로 고객 정보를 받아오는지 확인합니다.



## Level 2

### RememberMeServices 적용하기

JWT를 사용하므로 TokenBasedRememberMeServices를 사용해서 구현해도 좋으며, 백엔드 서버에 토큰을 저장하는 방식인 PersistentTokenBasedRememberMeServices를 사용해서 구현해도 좋습니다.



## Level 3

### OAuth2 클라이언트 연동하기 (소셜로그인 연동)

이미 5주차 강의에서 카카오 로그인을 다루고 있어서, 카카오가 아닌 다른 회사(네이버, 구글 ...) 중 하나를 골라 그 회사에서 제공하는 OAuth2 인증 서버를 활용해 소셜로그인이 지원되도록 구현합니다. 



# 과제 수행 방법

1. 해당 레포지토리를 fork를 합니다.
2. 과제를 수행하신 뒤, Pull request를 만들어서 보내주시면 됩니다.