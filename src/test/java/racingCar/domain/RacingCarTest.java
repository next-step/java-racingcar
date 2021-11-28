package racingCar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingCarTest {

  @DisplayName("Test init car.")
  @ParameterizedTest
  @MethodSource(value = "generateMyNumberInputs")
  public void testInitPosition(int number1, int number2, int compareResult) {
    RacingCar racingCar1 = new RacingCar("car1");
    RacingCar racingCar2 = new RacingCar("car2");

    racingCar1.tryMove(new MyNumber(number1));
    racingCar2.tryMove(new MyNumber(number2));

    assertEquals(racingCar1.compareTo(racingCar2), compareResult);
  }

  private static Stream<Arguments> generateMyNumberInputs() {
    return Stream.of(
        Arguments.of(5, 0, 1),
        Arguments.of(0, 5, -1),
        Arguments.of(0, 1, 0)
    );
  }
}
