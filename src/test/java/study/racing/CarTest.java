package study.racing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @Test
  @DisplayName("전진테스트")
  void move() {
    Car car = new Car();
    car.move(() -> true);
    assertEquals(car.getPosition(), 1);
  }

  @Test
  @DisplayName("4 미만일 때, 정지")
  void stop() {
    Car car = new Car();
    car.move(() -> false);
    assertEquals(car.getPosition(), 0);
  }

}