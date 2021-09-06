### 5단계 리팩토링
### 

MVC 패턴 기반으로 리팩토링해 `view` 패키지의 객체가 `domain` 패키지 객체에 의존할 수 있지만,
`domain` 패키지의 객체는 `view` 패키지 객체에 의존하지 않도록 구현한다.
### 

### TODO
- package 분리(domain, view)
- 의존성 분리
  - `domain` 단위 테스트 시 `view`에 의존적이지 않은지 확인
