# 🚀 5단계 - 자동차 경주(리팩토링)
## 리팩토링 요구사항
- 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
- MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

  ![](.\img\domain.PNG)

- 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.
  ![](.\img\domain2.PNG)

## 리팩토링 To-do List
- [X] StartView.java 삭제 반영
- [X] Car : Car 클래스 location 상태값 클래스로 분리
- [X] Car의 getLocation 삭제 (getLocation을 호출하는 곳을 메세지 전송 형태로 변경)
- [X] Car : Car name 유효성 검사에서 String API isBlank 사용하도록 변경
- [X] Car : name 변수 클래스로 분리
- [X] Car : getName 삭제 (getName을 호출하는 곳을 메세지 전송 형태로 변경)
- [X] Cars : winners 일급 콜랙션 클래스 분리
- [X] Race : ArrayList cars를 일급 컬랙션 클래스로 분리
- [X] Overall : 인스턴스 변수의 default 값을 명시적 초기화가 아닌 생성자에서 초기화 되도록 변경
- [X] ResultView : Iterator 사용에 Casting 제거
- [X] Race : getWinner에서 sort 구현에서 comparator 객체 사용이 아닌 comperable 인터페이스를 구현하는 방식으로 변경
- [X] MovingStrategy : Car의 전진 가능 여부를 인터페이스 형태로 만들어 구현
- [X] RaceTest : 변경된 구조에 따라 Test 변경
- [X] Race : RoundNum 원시 데이터를 Class로 분리
- [X] Race : CurrentRound 원시 데이터를 Class로 분리
