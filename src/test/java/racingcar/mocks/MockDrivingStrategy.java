package racingcar.mocks;

import racingcar.util.DrivingStrategy;

/**
 *
 * Car 객체의 move() 메소드 테스트를 위한 Mock 객체
 * move() 메소드는 random함수를 통해 4 이상의 int를 받을때에만 position += 1
 */
public class MockDrivingStrategy implements DrivingStrategy {

  private static DrivingStrategy drivingStrategy;

  private MockDrivingStrategy() {}

  public static DrivingStrategy getInstance() {
    if (drivingStrategy == null) drivingStrategy = new MockDrivingStrategy();
    return drivingStrategy;
  }

  @Override
  public int throwDice() {
    return 10;
  }

}
