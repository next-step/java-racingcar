package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;


public class MovementTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @Test
  @DisplayName("[Movement] 자동차를 움직이지 않았을 때의 트랙 테스트")
  void trackingMovementTest() {
    assertEquals("", Movement.trackingMovement(car, "-"));
  }

  @Test
  @DisplayName("[Movement] 자동차를 움직이고 난 후의 트랙 테스트")
  void trackingAfterMovementTest() {
    car.move();
    assertEquals("-", Movement.trackingMovement(car, "-"));
  }
}
