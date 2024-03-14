## REVIEW

이름 입력 받는 부분 validation check 필요!!! -> ok
매직넘버 추출! -> good
RoundRecord stream 사용시 map<String, Integer> -> List<Car> : stream 공부 후 수정 해보기!
ResultView에서 MessageFormat 메서드화 -> ok

## Todo

각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분한다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## Feat

- 이름 입력 받는 부분 validation check 필요!!! ->
- 자동차 이름 입력 받는 부분 필요 -> InputView String[] ok
- 몇대가 시작할 것인지 받는대신 이름으로 파악 ok
- String[] -> CarGame() -> split(",") -> ok
- -> Car 필드에 추가, 객체 생성(이름배열length) -> ok
- 출력부 ResultView print에 포지션이랑 이름도.. 표현해줘야함.. -> ok
- 우승자 파악 -> 무슨 방법으로 파악하지... -> 출력부 00,00가 최종 우승했습니다. -> ok

## Test

## Done

## Hint

규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다. else를 사용하지 않아 indent를 줄일 수 있다.
자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
String[] names = inputName.split(",");
사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

## 요구사항

1. indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
   예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
2. 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
3. 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
4. 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
5. 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
6. UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
7. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
8. else 예약어를 쓰지 않는다.
   힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
