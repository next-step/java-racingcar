package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomCarMovingStrategyTest {

  @DisplayName("움직일지 판단 할 시 3 이하 random 수로 뽑힐시 false를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void isMove_returnFalse(int randomNum) {

    Random randomStub = new Random() {
      @Override
      public int nextInt(int bound) {
        return randomNum;
      }
    };

    assertFalse(new RandomCarMovingStrategy(randomStub).canMove());
  }

  @DisplayName("움직일지 판단 할 시 4 이상 random 수로 뽑힐시 true를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void isMove_returnTrue(int randomNum) {

    Random randomStub = new Random() {
      @Override
      public int nextInt(int bound) {
        return randomNum;
      }
    };

    assertTrue(new RandomCarMovingStrategy(randomStub).canMove());
  }
}
