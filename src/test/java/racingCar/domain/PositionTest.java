package racingCar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PositionTest {

  @Test
  @DisplayName("Test init position.")
  public void testInitPosition() {
    Position position = new Position(1);
    assertEquals(position.getValue(), 1);
  }

  @DisplayName("Test move position.")
  @ParameterizedTest
  @MethodSource(value = "generateMoveInputs")
  public void testMovePosition(int inputNumber, int expectedPosition) {
    MyNumber number = new MyNumber(inputNumber);
    Position position = new Position(0).move(number);
    assertEquals(position.getValue(), expectedPosition);
  }

  private static Stream<Arguments> generateMoveInputs() {
    return Stream.of(
        Arguments.of(4, 0),
        Arguments.of(5, 1)
    );
  }
}
