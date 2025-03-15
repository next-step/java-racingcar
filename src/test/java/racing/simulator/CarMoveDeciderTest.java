package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarMoveDeciderTest {

  @DisplayName("canMove() 함수를 호출 시 4 이하 random한 수로 뽑힐시 false를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3 ,4})
  void canMove_returnFalse(int randomNum) {
    Random mockRandom = Mockito.mock(Random.class);

    Mockito.when(mockRandom.nextInt(10)).thenReturn(randomNum);

    assertFalse(new CarMoveDecider(mockRandom).canMove());
  }

  @DisplayName("canMove() 함수를 호출 시 5 이상 random한 수로 뽑힐시 true를 반환한다.")
  @ParameterizedTest
  @ValueSource(ints = {5, 6, 7, 8 ,9})
  void canMove_returnTrue(int randomNum) {
    Random mockRandom = Mockito.mock(Random.class);

    Mockito.when(mockRandom.nextInt(10)).thenReturn(randomNum);

    assertTrue(new CarMoveDecider(mockRandom).canMove());
  }
}
