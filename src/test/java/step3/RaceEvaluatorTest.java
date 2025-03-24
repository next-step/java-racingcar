package step3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import org.junit.jupiter.api.Test;

class RaceEvaluatorTest {

  @Test
  void 랜덤값이_임계점_이상이면_자동차가_전진한다() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 4;
      }
    };
    RaceEvaluator raceEvaluator = new RaceEvaluator(testRandom);

    assertTrue(raceEvaluator.evaluate());
  }

  @Test
  void 랜덤값이_임계점_미만이면_자동차가_전진하지_않는다() {
    Random testRandom = new Random() {
      @Override
      public int nextInt(int bound) {
        return 3;
      }
    };
    RaceEvaluator raceEvaluator = new RaceEvaluator(testRandom);

    assertFalse(raceEvaluator.evaluate());
  }
} 