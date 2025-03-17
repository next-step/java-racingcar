package step4.carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRacingTest {
  private static final Set<Integer> VALID_RANDOM_NUMBERS = new HashSet<>(Arrays.asList(
          0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  @DisplayName("0-9 사이 랜덤으로 자동차 이동 전략을 구하는 테스트")
  @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void testGetMoveSteps() {
    int actual = new RandomCarMoveStrategy().getMoveSteps();
    assertTrue(VALID_RANDOM_NUMBERS.contains(actual));
  }

  @DisplayName("자동차가 4 이상일때 움직이는 테스트")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void testMove(int number) {
    Car car = new Car();
    int currentPosition = car.getPosition();

    car.move(number);

    assertEquals(currentPosition + 1, car.getPosition());
  }

  @DisplayName("자동차가 4 미만일때 움직이는 테스트")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void testNotMove(int number) {
    Car car = new Car();
    int currentPosition = car.getPosition();

    car.move(number);

    assertEquals(currentPosition, car.getPosition());
  }
}
