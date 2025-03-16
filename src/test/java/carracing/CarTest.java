package carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
  @DisplayName("4 이상의 숫자일 때 자동차가 이동하는지를 테스트한다.")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void testCarMove(int number) {
    Car testCar = new Car();
    int currentPosition = testCar.getPosition();

    testCar.move(number);

    Assertions.assertEquals(currentPosition + 1, testCar.getPosition());
  }

  @DisplayName("4 미만의 숫자일 때 자동차가 이동하지 않는지를 테스트한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void testCarDoNotMove(int number) {
    Car testCar = new Car();
    int currentPosition = testCar.getPosition();

    testCar.move(number);

    Assertions.assertEquals(currentPosition, testCar.getPosition());
  }
}