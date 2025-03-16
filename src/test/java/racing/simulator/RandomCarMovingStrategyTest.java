package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

class RandomCarMovingStrategyTest {

  @DisplayName("움직일지 판단 할 시 3 이하 random 수로 뽑힐시 false를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void canMove_returnFalse(int randomNum) {
    Random mockRandom = Mockito.mock(Random.class);

    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);

    assertFalse(new RandomCarMovingStrategy(mockRandom).isMove());
  }

  @DisplayName("움직일지 판단 할 시 4 이상 random 수로 뽑힐시 true를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void canMove_returnTrue(int randomNum) {
    Random mockRandom = Mockito.mock(Random.class);

    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);

    assertTrue(new RandomCarMovingStrategy(mockRandom).isMove());
  }
}
