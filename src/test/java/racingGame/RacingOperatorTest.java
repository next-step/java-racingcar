package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingOperatorTest {

  private RacingOperator racingOperator;
  private Cars cars;

  @BeforeEach
  void setUp() {
    String rawInput = "a,b,c,d";
    ScoreGenerator scoreGenerator = new DummyScoreGenerator();
    this.cars = Cars.of(rawInput);
    this.racingOperator = RacingOperator.of(this.cars, scoreGenerator);
  }


  @DisplayName("move 테스트")
  @Test
  void testMoveExactly() {
    this.racingOperator.moves();
    List<Integer> expected = new Vector<>();
    expected.add(1);
    expected.add(0);
    expected.add(1);
    expected.add(0);

    assertThat(this.racingOperator.getPositions())
        .isEqualTo(expected);
  }

  @DisplayName("우승자 테스트")
  @Test
  void whoIsWinner() {
    this.racingOperator.moves();
    List<String> expected = new Vector<>();
    expected.add("a");
    expected.add("c");

    assertThat(this.racingOperator.extractWinners()).isEqualTo(expected);
  }
}
