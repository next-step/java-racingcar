package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @DisplayName("자동차가 4 이상일때 움직이는 테스트")
  @Test
  void testMove() {
    Car car = CarFactory.createCar("test", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy());
    int currentPosition = car.getPosition();

    car.move();

    Assertions.assertEquals(currentPosition + 1, car.getPosition());
  }

  @DisplayName("자동차가 4 미만일때 움직이는 테스트")
  @Test
  void testNotMove() {
    Car car = CarFactory.createCar("test", new CarMoveStrategyTest.TestStoppedCarMoveStrategy());
    int currentPosition = car.getPosition();

    car.move();

    Assertions.assertEquals(currentPosition, car.getPosition());
  }
}