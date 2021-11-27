5단계 - 자동차 경주(리팩토링)
---

### 리팩토링 요구사항
- 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현
- MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현


### 피드백 기반으로 리팩토링 목록
- CarName 일급 컬렉션
- 필드명과 클래스명은 동일하지 않게 수정
- dto package에 domain과 dto 구분
- Test code 추가 작성
- 불변객체에 final 키워드
- 비즈니스 로직상의 예외는 사용자 예외로 별도 관리
- method reference 애용
- 매번 Random 인스턴스 생성은 메모리 낭비이므로 수정
- RacingGameService는 싱글톤으로 관리


### 추가 테스트 항목
- CarName 동일한지 테스트
- findWinner 테스트
- CarNames 일급 컬렉션 테스트


### 미션 제출 전 확인
- [x] 불변 객체는 final 키워드 작성
- [x] 매직 리터럴 제거
- [x] package 구성
- [x] 불필요한 인스턴스, import 제거
- [x] 충분한 테스트 케이스
- [] 간단 명료한 설계
