package racingGame;

import org.junit.jupiter.api.BeforeEach;

class RacingOperatorTest {

  private RacingOperator racingOperator;

  @BeforeEach
  void setUp() {
    String rawInput = "a,b,c,d";
    racingOperator = RacingOperator.of(Cars.of(rawInput));
  }
}
