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
- [ ] 경주 완료 후 우승자 찾기 (여러명 가능) - `findWinners()`
  - cars의 `findMaxPositionCars()` 메서드 호출
### OutputView
- [ ] 게임 결과 출력 시 자동차 이름 같이 표시해야 함
- [ ] 게임 종료 후 우승자 출력 필요