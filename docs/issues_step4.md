# Issues
## TDD
- 수정사항 발생 시 테스트를 전부 수정?
## RacingCarCurrentStatus
- 객체의 이름, 위치, 역할
## 원시 자료형 래핑
- RacingGame 생성자
  ```java
   public RacingGame(String[] namesOfCar, Integer numberOfTrial, Moveable moveable);
   ```

  ```java
   public RacingGame(RacingCarNames racingCarNames, NumberOfTrial numberOfTrial, Moveable moveable);
   ```
  
    - 래핑된 클래스를 생성자에서 받는 설계가 더 유연
    - 편의성을 위해 정적 팩토리 메서드를 추가: `RacingGame.of(String[], int, Moveable)`