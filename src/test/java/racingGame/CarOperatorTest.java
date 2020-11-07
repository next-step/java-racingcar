package racingGame;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import racingGame.View.InputView;

class CarOperatorTest {

  private CarOperator carOperator;

  @BeforeEach
  void setUp() {
    String rawInput = "a,b,c,d";
    List<String> parsedInput = InputView.parseRawInput(rawInput);

    carOperator = CarOperator.of(Cars.of(parsedInput));
  }
}
