package camp.nextstep.racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

  @Test
  void move() {
    CarRacing carRacing = new CarRacing();
    List<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1));
    List<Integer> nextState = carRacing.move(initialState, 0);
    assertThat(nextState.get(0)).isEqualTo(2);
    assertThat(nextState.get(1)).isEqualTo(1);
    assertThat(nextState.get(2)).isEqualTo(1);
    assertThat(nextState.get(3)).isEqualTo(1);
  }

  @Test
  void performTick() {
    CarRacing carRacing = new CarRacing();
    List<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1));
    List<Integer> nextState = carRacing.performTick(initialState);
    assertThat(nextState).contains(1).doesNotContain(0, 3);
  }
}