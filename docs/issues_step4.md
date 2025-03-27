# Issues
## TDD
- 수정사항 발생 시 테스트를 전부 수정?
## RacingCarCurrentStatus
- 객체의 이름, 위치, 역할
## 원시 자료형 래핑
- RacingGame 생성자
  ```java
   public RacingGame(String[] namesOfCar, Integer tryCount, Moveable moveable);
   ```

  ```java
   public RacingGame(RacingCarNames racingCarNames, NumberOfTrial tryCount, Moveable moveable);
   ```
  
    - 래핑된 클래스를 생성자에서 받는 설계가 더 유연
    - 편의성을 위해 정적 팩토리 메서드를 추가: `RacingGame.of(String[], int, Moveable)`
### NumberOfTrials
- numberOfTrials 만큼 입력받은 함수를 반복하는 기능이 `NumberOfTrials` 내부에 존재해도 되는가?
  - NumberOfTrials 는 단순히 횟수를 나타나는 객체이므로 반복 기능을 넣는 것은 적합하지 않음
## 객체의 책임
- RacingGameResult
  ```java
  private Position updateMaxPosition(RacingCarCurrentStatus carStatus, Position maxPosition) {
        if (car.whereIsThisCarNow() > maxPosition) {
            maxPosition = carStatus.position();
        }
        return maxPosition;
  }
  ```

  ```java
  private Position updateMaxPosition(RacingCarCurrentStatus carStatus, Position maxPosition) {
    if (carStatus.isAheadOf(maxPosition)) {
        maxPosition = carStatus.position();
    }
    return maxPosition;
  }
  ```
  - 책임과 데이터를 동일 객체로 묶음 -> 객체 지향의 핵심 원칙
    - `RacingCarCurrentStatus` 위치를 비교하는 로직을 `RacingGameResult`에 담으면 안됨
  - 실제로는 `Position` 객체를 비교하는 로직이므로 `Position` 객체에 비교 로직을 추가
