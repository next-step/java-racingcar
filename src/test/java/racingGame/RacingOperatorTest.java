package racingGame;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import racingGame.View.InputView;

class RacingOperatorTest {

  private RacingOperator racingOperator;

  @BeforeEach
  void setUp() {
    String rawInput = "a,b,c,d";
    List<String> parsedInput = InputView.parseRawInput(rawInput);

    racingOperator = RacingOperator.of(Cars.of(parsedInput));
  }
}
