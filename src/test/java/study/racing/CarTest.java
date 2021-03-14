package study.racing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  @DisplayName("4 이상일 때, 전진")
  void move(int condition) {
    Car car = new Car();
    car.move(new NumberConditionMoveStrategy(), condition);
    assertEquals(car.getPosition(), 1);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  @DisplayName("4 미만일 때, 정지")
  void stop(int condition) {
    Car car = new Car();
    car.move(new NumberConditionMoveStrategy(), condition);
    assertEquals(car.getPosition(), 0);
  }

}