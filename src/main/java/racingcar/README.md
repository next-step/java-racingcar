# 자동차 경주 게임
## Step3 기능 요구 사항
### Position
- [x] 자동차의 현재 위치를 저장하는 클래스
- [x] 위치 정보를 임의로 지정하거나 기본 값 (0) 생성자를 지원
- [x] 현재 위치 값을 1 증가 시키는 `move()` 메소드 제공
### Car
- [x] `Position`을 인스턴스 변수로 갖는다
- [x] 인자로 받는 함수형 인터페이스 반환 값에 따라 전진하거나 정지해있는 `move()` 메소드 제공
  - 내부적으로 `Position`의 `move()` 메소드 호출
### MovingStrategy
- [x] 함수형 인터페이스로, `move()` 메소드에 전달되어 전진 여부를 결정할 수 있도록 함
  - [x] 랜덤 값을 생성하여 4 이상 값 생성 시 `true`를 반환하는 구현체 만들기
### Cars
- [x] `List<Car> cars` 을 유일한 인스턴스 변수로 갖는 일급 콜렉션 클래스
- [x] 지정한 대수의 자동차를 가지도록 생성할 수 있는 생성자 제공
- [x] `cars`의 원소들 각각의 `move()` 메소드를 한 번에 호출해주는 메소드 제공
### RacingCarGame
- [x] `게임 진행 횟수`와 `자동차 대수`를 전달받아 객체 생성,
  - [x] `Cars`의 `move()` 메소드를 실행하는 `play()`메소드 제공
  - [x] `게임 진행 횟수` 만큼 `move()`가 실행되었는지 반환하는 `isEnd()` 메소드 제공
### InputView
- [x] 자동차 대수 입력 받기
- [x] 몇 회 전진할 지 입력 받기
### ResultView
- [x] 매 이동마다 실행 결과 출력
  - [x] 현재 자동차 `position`에 따른 실행 결과 출력을 위한 문자열 (ex. `"---"`) 생성 필요
### GameController
- [x] 입력, 출력, 게임 진행 전반을 제어하는 컨트롤러
- [x] `RacingCarGame.isEnd()` 의 값이 false면 계속해서 `move()` 메소드를 호출해 게임을 진행한다

---

## 리팩토링 요구 사항
- [x] `MovingStrategy` 팩토리로 주입
- [x] `strategy` 패키지 분리
- [x] `RandomMovingStrategy`의 `Random` 객체 매번 생성하지 않고 재사용 되도록
- [x] `GameController`의 `RacingCarGame` 생성 부분 팩토리로 분리
- [x] `Cars.move()` 에서 `ArrayList` 를 매번 생성해 반환하지 않고 필드인 `List<Car>`를 반환하도록 수정

## Step4 기능 요구 사항
### Car
- [x] 자동차에 이름 부여 가능
  - `Name` 클래스로 분리
### Name
- [x] 자동차 이름을 저장
- [x] 생성 시 유효하지 않은 입력 예외 처리 수행
  - 자동차의 이름은 1~5자여야하며, null도 허용하지 않음
### InputView
- [x] 자동차 이름 입력 받기
  - [x] 자동차 이름은 쉼표 `,` 를 기준으로 구분
### Position
- [x] 주어진 `Position` 객체와 자신을 비교하여 더 큰 객체를 반환하는 `getBigger()` 구현
### Car
- [x] 주어진 `Car` 객체와 자신을 비교하여 같은 Position 값이 같으면 true를 반환하는 `isPositionEquals(Position position)` 구현
### Cars
- [x] 가장 앞서 있는 자동차의 Position 값 찾기 - `findMaxPosition()`
  - `List<Car>`의 getPosition() 값을 순회하며 `Position.getBigger()` 호출
- [x] `Car.isPositionEqual(maximum Position 값)`이 `true`인 `List<Car>`를 반환하는 메서드 제공 - `findMaxPositionCars()`
### RacingCarGame
- [x] 경주 완료 후 우승자 찾기 (여러명 가능) - `findWinners()`
  - cars의 `findMaxPositionCars()` 메서드 호출
### OutputView
- [x] 게임 결과 출력 시 자동차 이름 같이 표시해야 함
- [x] 게임 종료 후 우승자 출력 필요

---

## Step5 리팩토링 요구사항
### 공통
- [x] Stream 활용 가능한 부분 찾고 적극 적용하기
### PlayResult
- [x] Car과 CarDto를 분리하기 (PlayResult를 CarDto로 사용)
- [x] 구조 변경에 맞게 나머지 코드 리팩토링
  - [x] `Car`에 `PlayResult getPlayResult()` 메소드 추가
  - [x] `Car`에 나머지 getter 메소드 삭제
  - [x] `Car`의 `isPositionEquls()`와 `getBiggerPosition()` 메서드 `PlayResult`로 이동
  - [x] `Cars`의 `move()` 메소드의 반환 값을 없애고, `getPlayResults()`가 `List<PlayResult>`를 반환하도록 수정 (cqrs 만족)
  - [x] `RecingCarGame`에도 마찬가지로 cqrs 적용
  - [x] `findWinner` 관련 로직 `RacingCarGame` 클래스로 이동
  - [x] `ResultView` 로직 `List<Car>` 대신 `List<PlayResult>`를 받아 출력하도록 수정
  - [x] 관련 테스트 추가 및 수정
### RacingCarGame
- [x] `getMaxPosition()` 로직을 `Stream.max()`를 사용하도록 변경
  - [x] 연관된 `PlayResult.getBiggerPosition()`, `Position.getBigger()` 메소드 삭제
  - [x] `Position`에 `compareTo` 구현
- [x] findWinners()에서 `List<PlayResult>`를 불변 객체로 반환하도록 수정
### Name
- [x] validation 시 trim 이후 한번에 validate 하도록 수정
### Position
- [x] 음수 값 들어가지 못하도록 validation 로직 추가
### MovingStrategyType
- [x] Type이 value로 `Supplier` 를 갖도록 변경하여 Enum 만으로 Type에 해당하는 MovingStrategy 구현체를 얻을 수 있도록 수정
### ResultView
- [x] 괄호 제거하는 로직 -> `Collections.joining` 으로 개선
### CarsTest
- [x] `create()`에서 테스트하고자 하는 대상인 `생성`과 실제 테스트인 `move()`의 목적이 일치하지 않는 문제 수정
