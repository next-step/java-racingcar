package racingrefactoring.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveConditionTest {

  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void 움직일_수_있는_조건인_경우(int randomNumber) {
    assertThat(MoveCondition.canMove(randomNumber)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void 움직일_수_없는_조건인_경우(int randomNumber) {
    assertThat(MoveCondition.canMove(randomNumber)).isFalse();
  }
}