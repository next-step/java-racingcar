## 3단계 - 자동차 경주

### 기능 요구 사항
- 자동차 경주게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 클래스 설명 (핵심 로직 구현 클래스)
- **RacingCar** : 자동차 경주 게임의 대상이 되는 자동차 클래스로, 각 이동 횟수별 전진/멈춤 기록을 담은 히스토리 배열을 갖고 있다.
- **RacingCarFactory** : RacingCar를 자동차 갯수, 이동횟수 값에 따라 List<RacingCar> 값을 만들어 리턴하는 static 메서드를 작성한다. 
  
 
### 클래스 설명 (UI 담당 클래스)
- **InputView** : 사용자에게 자동차 갯수(numOfCars)와 몇번의 이동(tryingCount)을 할것인지 입력을 받고, 해당 입력값을 리턴하는 정적 메서드를 정의한다.
- **ResultView** : `RacingCar` 리스트를 멤버로 갖는 출력용 클래스로, 각 `RacingCar`의 전진/멈춤 기록 히스토리를 순차적으로 출력한다.
추가로 멤버로 RacingCar 리스트 크기와 같은 `StringBuilder` 리스트를 추가로 갖고있어, 이전 히스토리 출력 기록을 `StringBuilder`에 기록해 놓기위해 출력에 해당 필드를 활용한다.

### 메인 클래스 설명
- **Main** : 각 클래스들을 선언하고 실행시키는 메인 클래스이다. 
  1) `InputView`의 메서드들을 호출하여 사용자들로부터 필요한 숫자값을 입력받는다. 
  2) `RacingCar` 리스트를 `RacingCarFactory`를 통해 생성한다,
  3) `ResultView`에서 출력하기 위해 초기화한 `RacingCar` 리스트를 전달하고, 최종 경주게임 내용을 출력하는 메서드를 호출한다.

## 테스트 클래스 설명
- **RacingCarTest** : RacingCar클래스의 초기화 과정, 각 public 메서드를 호출하여 성공 / 실패하는 테스트 케이스를 추가한다.
- **RacingCarFactoryTest** :RacingCarFactory에 한개 선언되어있는 static 메서드(manufactoringCars)에 대한 테스트 케이스를 추가한다.
