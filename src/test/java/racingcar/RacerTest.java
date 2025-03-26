package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class RacerTest {

  @Test
  void 모든_자동차가_전진하는_경우() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 4;
      }
    };
    RaceEvaluator evaluator = new RaceEvaluator(testRandom);
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    Racer racer = new Racer(names, 3, evaluator);

    Result result = racer.race();

    assertThat(result.getRoundResult(0).at(0).getPosition()).isEqualTo(1);
    assertThat(result.getRoundResult(0).at(1).getPosition()).isEqualTo(1);
    assertThat(result.getRoundResult(1).at(0).getPosition()).isEqualTo(2);
    assertThat(result.getRoundResult(1).at(1).getPosition()).isEqualTo(2);
    assertThat(result.getRoundResult(2).at(0).getPosition()).isEqualTo(3);
    assertThat(result.getRoundResult(2).at(1).getPosition()).isEqualTo(3);
  }

  @Test
  void 자동차가_전진하지_않는_경우() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 3;
      }
    };
    RaceEvaluator evaluator = new RaceEvaluator(testRandom);
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    Racer racer = new Racer(names, 3, evaluator);

    Result result = racer.race();

    assertThat(result.getRoundResult(0).at(0).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(0).at(1).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(1).at(0).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(1).at(1).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(2).at(0).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(2).at(1).getPosition()).isEqualTo(0);
  }

  @Test
  void 혼재되어_전진하는_경우() {
    int[] values = {4, 3, 4, 3, 3, 4};
    Random testRandom = new Random() {
      private int index = 0;

      @Override
      public int nextInt(int bound) {
        return values[index++];
      }
    };
    RaceEvaluator evaluator = new RaceEvaluator(testRandom);
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    Racer racer = new Racer(names, 2, evaluator);

    Result result = racer.race();

    assertThat(result.getRoundResult(0).at(0).getPosition()).isEqualTo(1);
    assertThat(result.getRoundResult(0).at(1).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(0).at(2).getPosition()).isEqualTo(1);
    assertThat(result.getRoundResult(1).at(0).getPosition()).isEqualTo(1);
    assertThat(result.getRoundResult(1).at(1).getPosition()).isEqualTo(0);
    assertThat(result.getRoundResult(1).at(2).getPosition()).isEqualTo(2);
  }
}
