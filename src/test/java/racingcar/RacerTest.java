package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
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

    Cars expectedRound1 = new Cars(
        List.of(
            new Car("car1", 1),
            new Car("car2", 1),
            new Car("car3", 1)
        )
    );
    Cars expectedRound2 = new Cars(
        List.of(
            new Car("car1", 2),
            new Car("car2", 2),
            new Car("car3", 2)
        )
    );
    Cars expectedRound3 = new Cars(
        List.of(
            new Car("car1", 3),
            new Car("car2", 3),
            new Car("car3", 3)
        )
    );

    assertAll(
        () -> assertThat(result.getRoundResult(0)).isEqualTo(expectedRound1),
        () -> assertThat(result.getRoundResult(1)).isEqualTo(expectedRound2),
        () -> assertThat(result.getRoundResult(2)).isEqualTo(expectedRound3)
    );
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

    Cars expectedRound = new Cars(
        List.of(
            new Car("car1", 0),
            new Car("car2", 0),
            new Car("car3", 0)
        )
    );

    assertAll(
        () -> assertThat(result.getRoundResult(0)).isEqualTo(expectedRound),
        () -> assertThat(result.getRoundResult(1)).isEqualTo(expectedRound),
        () -> assertThat(result.getRoundResult(2)).isEqualTo(expectedRound)
    );
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

    Cars expectedRound1 = new Cars(
        List.of(
            new Car("car1", 1),
            new Car("car2", 0),
            new Car("car3", 1)
        )
    );
    Cars expectedRound2 = new Cars(
        List.of(
            new Car("car1", 1),
            new Car("car2", 0),
            new Car("car3", 2)
        )
    );

    assertAll(
        () -> assertThat(result.getRoundResult(0)).isEqualTo(expectedRound1),
        () -> assertThat(result.getRoundResult(1)).isEqualTo(expectedRound2)
    );
  }
}
