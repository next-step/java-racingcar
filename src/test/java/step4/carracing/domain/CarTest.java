package step4.carracing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.carracing.CarMoveStrategyTest;
import step4.carracing.RandomCarMoveStrategy;

public class CarTest {

  @DisplayName("자동차가 움직이는지 확인하는 테스트")
  @Test
  void testMove() {
    Car car = new Car(0, "test", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy());

    car.move();

    Assertions.assertTrue(car.isSamePosition(1));
  }

  @DisplayName("자동차의 위치가 같은지 확인하는 테스트")
  @Test
  void testIsSamePosition() {
    Car car = new Car(0, "test", new RandomCarMoveStrategy());

    Assertions.assertTrue(car.isSamePosition(0));
  }

  @DisplayName("자동차의 최대 위치를 구하는 테스트")
  @Test
  void testCompareMaxPosition() {
    Car car = new Car(0, "test", new RandomCarMoveStrategy());

    Assertions.assertEquals(3, car.compareMaxPosition(3));
  }

  @DisplayName("자동차의 이름과 위치를 문자열로 반환하는 테스트")
  @Test
  void testToString() {
    Car car = new Car(0, "pobi", new RandomCarMoveStrategy());

    Assertions.assertEquals("pobi : -", car.toString());
  }
}