# Step3 간단 자동차 경주 구현

## 구조 개요

1개의 진입점 클래스와 2개의 UIView 클래스, 1개의 메인 로직 클래스로 구성되어 있다.

테스트는 메인 로직 클래스인 RacingGame 클래스만 수행한다.

모든 의존성은 진입점 클래스만 가지고 있다.

- 진입점 클래스
  - RacingGamePlayer
- UI 클래스
  - InputView
  - ResultView
- 메인 로직 클래스
  - RacingGame

### RacingGame 클래스 기능

#### 1. constructor

 - 차 이름들을 입력 받아 몇대를 어떤 레이서들로 레이싱 할 건지 초기화 한다.
 - 이때 RacingGame 클래스는 내부적으로 자동차들의 현재 위치 상태를 저장하고 있다.
 
#### 2. move()

 - 랜덤으로 몇몇 차들의 위치를 한칸 앞으로 전진 시킨 후에 차들의 위치를 리턴한다.
   - 이때 불변을 위해 (retun된 Map<String,Integer>로의 접근으로 무분별한 위치 변경을 차단 시키기 위해) new 로 리턴한다.

#### 3. getWinner()

  - 현재 상태에서의 우승자를 리턴한다.