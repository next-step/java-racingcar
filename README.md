# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## calculator.CalculatorTest
### 요구사항 분석
### To do
* [x] 빈 문자열 혹은 null 값을 입력할 경우 0을 반환한다. ("" => 0, null => 0)
* [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. ("1" => 1)
* [x] 쉼표 혹은 콜론을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 값의 합을 반환한다. ( "1,2:3" => 6)
* [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우, RuntimeException 예외 throw한다. ("-1:2:3" => RuntimeException)
* [x] 커스텀 구분자를 지정할 수 있다. ("//;\n1;2;3" => 6)

### Feedback
* [x] junit4 의존성 삭제
* [x] 유닛 테스트 네이밍 코드 컨벤션 적용
* [x] 한 번만 수행해도 되는 코드 분리 (Patter.compile / split)
* [X] 양수임을 보장하는 값 객체를 활용한 숫자 이외의 값 혹은 음수 검증
* [x] Array => List 변경
* [x] ParameterizedTest를 활용한 여러 개의 테스트 수행

### Feedback 23.11.09
* [x] 객체를 만들었다면 객체간 소통이 되도록 작성해보기(PositiveNumber class)
  * 반환 값을 PositiveNumber로 하여 반환값을 보장하고, 생성자에서 예외를 던지도록 변경
---

## racingCar.racingCarTest
##### step3
### 요구사항 분석
### 원칙
* [x] README.md 파일에 구현할 기능 목록을 정리한다.
* [x] git commit 단위는 아래 정리한 기능 목록 단위로 추가한다.
* [x] Java 코드 컨벤션을 지키면서 프로그래밍한다. (IntelliJ idea Code Style.java)
* [x] else 예약어를 쓰지 않는다.
* [x] UI 로직을 제외한 모든 로직에 단위 테스트를 구현한다.
* [x] 핵심 로직 구현 코드와 UI 담당 로직을 구분한다.
* [x] UI 로직은 별도 클래스를 추가해 분리한다. (InputView, ResultView)

### To do
* [x] 자동차 대수와 횟수를 사용자에게 입력받는다. (3, 5)
* [x] 자동차 대수만큼 자동차를 생성한다.
* [x] 전진 조건은 랜덤 값을 구해 4 이상인 경우이다.
* [x] 각 자동차는 멈추거나 전진한다,(움직인다)
* [x] 결과를 화면에 출력한다. 출력 시점의 제약은 없다.


### Feedback 23.11.09
* [x] 사용자 입력을 받기 위해 InputView를 매번 생성하는 것이 아닌, 필요한 정보를 얻을 수 있는 메서드를 별도 구현
* [x] 애플리케이션이 실행되는 main의 구조 변경
* [x] RacingCar에 static으로 구현된 메서드를 모두 별도의 클래스로 옮겨 각자 책임을 부여
* [x] List<Car> 타입 변수를 CarList라는 일급 컬렉션으로 변경해서 관리
* [x] 전체적으로 OOP의 개념에 입각해 여러 객체를 도출하고 객체간 메시지를 주고받으며 협력하도록 구조 개선

### Feedback 23.11.12
* [x] 일급 컬렉션 CarList의 클래스명을 컬렉션 성격을 드러내지 않도록 변경한다.
* [x] InputView에서 사용자에게 입력받은 값을 InputView의 멤버변수, 정적변수로 두면 객체 재활용 시 문제가 됨. InputView에게 필요한 변수를 얻는 메서드로 구현하자.
* [x] 콘솔에서 출력하는 부분은 언제든지 바뀔 수 있으므로, CarList 내 ResultView 부분은 모두 제거하고, CarList에게 얻은 값을 ResultView에게 전달하도록 구현
* [x] ResultView 외 위치한 println()의 위치 변경
* [x] 현재 자동차 생성 시 CarList 생성 후 addCar, moveByTryCount의 순서가 보장되지 않는다. 팩터리 메서드를 이용해 CarList를 생성할 때 미리 Car객체를 생성하도록 해보자.
* [x] 현재 작성한 Car.move()의 결과값 범위 테스트보다는, 확실한 상태에 대한 Test를 작성하자. 의존성 역전에 대해 알아보고 적용해볼 것.
* [ ] CarList.moveByTryCount()에 대한 Test도 위에 언급한 바와 같다. 확실한 상태값에 대한 테스트를 진행하고, for loop / if-else와 같은 반복, 조건문을 지양한다.
  * 테스트 삭제
* [x] getRandomNumber() Test는 굳이 필요가 없을 듯 하다.

### Feedback 23.11.13
* [x] 의존성 역전을 통해 핵심 메서드인 move() 개선 + InputView, ResultView
* [ ] 현재 addCar()는 직접 제어할 수 없는 상태(테스트하기 힘들다.) 추후 개선 요망
---
##### step4
### 요구사항 분석
### 원칙
* [x] indent depth는 2가 넘지 않도록 구현한다.
* [x] 함수 길이가 15라인을 넘어가지 않도록 구현한다.
### To do
* [x] 각 자동차의 이름을 부여할 수 있다.
* [x] 자동차 이름은 5자를 초과할 수 없다.
* [x] 자동차 이름은 쉼표를 기준으로 구분한다.
* [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* [x] 자동차 게임을 완료한 후 누가 우승했는지를 알려준다.
* [x] 우승자는 여러명일 수 있다.

### Feedback
* [x] Car의 원시값 name을 포장한 CarName 클래스 추가