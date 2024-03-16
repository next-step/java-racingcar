# 자동차 경주(우승자)

## Todo
### 리뷰 반영 사항
- car에게 전략을 전달할지 고민해보고 개선히라(보류)


## Done
- Car 에서 이름에 대한 검증 책임을 갖게 하라
- Cars 클래스에서 Cars 생성자에 numberOfCars를 지니어야 하는지 고민해보고 개선하라
- 프로덕션 코드에서 반드시 0으로 position 을 생성한다면 name 만 전달받는 생성자를 추가해보는것 고려하고 개선하라
- unmodifiable collection의 정의를 제대로 확인하고 goForward 리턴값을 개선하라
- - position 을 getter 로 꺼내와서 값을 비교하지 말고 car에게 메세지를 보내서 처리하게 하라
- 객체지향이기 때문에 단순히 값을 보여주는 메서드말고 메시지를 보내는 형태로 설계하기
- showWinnerNames() - `.map(Car::getName)`
- winnerPosition() - `.mapToInt(Car::getPosition)`
- joining은 ui에 의존하는 메서드이기 때문에 ui에 의존적이지 않게 개선하라
- 테스트에서 사용하는 전략을 알맞은 패키지로 옮겨라
  - +내부에 전략을 전달받는 방법을 바로 true나 false를 리턴하는 방식으로 개선해보라(이유도 생각)
