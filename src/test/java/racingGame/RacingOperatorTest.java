package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingOperatorTest {

  private Cars cars;
  private RacingOperator racingOperator;
  private ScoreGenerator scoreGenerator;

  @BeforeEach
  void setUp() {
    String rawInput = "a,b,c,d";
    this.cars = Cars.of(rawInput);
    this.racingOperator = RacingOperator.of(this.cars);
    this.scoreGenerator = new DummyScoreGenerator();
  }

  @DisplayName("우승자 테스트")
  @Test
  void whoIsWinner() {
    this.racingOperator.moves(this.scoreGenerator);
    List<String> expected = new Vector<>();
    expected.add("a");
    expected.add("c");

    assertThat(this.racingOperator.extractWinners()).isEqualTo(expected);
  }
}
