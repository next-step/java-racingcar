# 5단계 - 자동차 경주(리팩토링)

---
## 리팩토링 요구사항
* 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
* **MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.**
* 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.

---
## Feature List
0. step4 소스 복사 커밋으로 시작!
1. Car 클래스,  MoveStrategy 인터페이스, DiceStrategy 클래스, BoundedDice 클래스 domain 패키지로 이동 (strategy 패키지는 도메인 패키지 하위로)
2. step4 코드리뷰 내용 반영
    1. AttemptResult.getWinnersNames 로직 개선
    2. AttemptResult.carWentResults에 final 키워드 추가
    3. RacingCars 생성자 private으로 숨기고 정적 팩토리 메소드 작성
    3. CarWentResult 불필요한 Comparable 구현 제거
    4. Reception.retryUntilGettingRightValue while, try-catch 로인한 2depth의 인덴트 1depth로 분리
    5. AttemptResultTest @ParameterizedTest 적용, 객체 생서 테스트 작성
3. System.in, System.out이 아닌 다른 입,출력이 있을 수 있으므로 InputChannel, OutputChannel 인터페이스와 그 구현체 작성