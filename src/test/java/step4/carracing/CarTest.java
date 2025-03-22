package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @DisplayName("자동차가 움직이는지 확인하는 테스트")
  @Test
  void testMove() {
    Car car = new Car(0, "test", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy());

    car.move();

    Assertions.assertTrue(car.isSame(1));
  }

  @DisplayName("자동차가 움직이지 않는지 확인하는 테스트")
  @Test
  void testNotMove() {
    Car car = new Car(0, "test", new CarMoveStrategyTest.TestStoppedCarMoveStrategy());

    car.move();

    Assertions.assertTrue(car.isSame(0));
  }
}