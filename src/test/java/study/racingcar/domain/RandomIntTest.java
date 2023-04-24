package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.factory.RandomIntFactory;

public class RandomIntTest {

  int start = RandomIntFactory.DEFAULT_START_BOUND;
  int end = RandomIntFactory.DEAFULT_END_BOUND - 1;

  @DisplayName("랜덤값은 랜덤Factory 범위 보다 작을 수 없다.")
  @ParameterizedTest
  @ValueSource(ints = {-1, -2, -10})
  public void randomInt_ThrowException_START_BOUND미만(int input) {
    assertThatThrownBy(() -> new RandomInt(start + input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("랜덤값은 랜덤Factory 범위 보다 클 수 없다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 10})
  public void randomInt_ThrowException_END_BOUND이상(int input) {
    assertThatThrownBy(() -> new RandomInt(end + input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("랜덤값은 Input 값 이상이면 움직인다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
  public void isMoving_True_Input이상(int input) {
    assertThat(new RandomInt(9).isGreaterThan(input)).isTrue();
    assertThat(new RandomInt(0).isGreaterThan(input)).isFalse();
  }
}
