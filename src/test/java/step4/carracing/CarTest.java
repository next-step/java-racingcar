package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
  @DisplayName("자동차가 4 이상일때 움직이는 테스트")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void testMove(int number) {
    Car car = CarFactory.createCar("test");
    int currentPosition = car.getPosition();

    car.move(number);

    Assertions.assertEquals(currentPosition + 1, car.getPosition());
  }

  @DisplayName("자동차가 4 미만일때 움직이는 테스트")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void testNotMove(int number) {
    Car car = CarFactory.createCar("test");
    int currentPosition = car.getPosition();

    car.move(number);

    Assertions.assertEquals(currentPosition, car.getPosition());
  }
}