package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarMoveStrategyTest {
  private static final Set<Integer> VALID_RANDOM_NUMBERS = new HashSet<>(Arrays.asList(
          0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  public static class TestAlwaysCarMoveStrategy implements CarMoveStrategy {
    @Override
    public boolean shouldMove() {
      return true;
    }
  }

  public static class TestStoppedCarMoveStrategy implements CarMoveStrategy {
    @Override
    public boolean shouldMove() {
      return false;
    }
  }

  @DisplayName("0-9 사이 랜덤으로 자동차 이동 전략을 구하는 테스트")
  @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void testGetMoveSteps() {
    int actual = new RandomCarMoveStrategy().getMoveSteps();
    Assertions.assertTrue(VALID_RANDOM_NUMBERS.contains(actual));
  }
}