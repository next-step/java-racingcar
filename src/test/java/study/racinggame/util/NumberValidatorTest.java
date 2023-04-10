package study.racinggame.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.racinggame.util.NumberValidator.validatedPositive;

public class NumberValidatorTest {

  @ParameterizedTest(name = "양수를 입력하는 경우 해당 양수 반환 테스트")
  @ValueSource(ints = {1, 3, 6, 9})
  public void validatedPositive_양수_반환(int input) {
    assertThat(validatedPositive(input)).isEqualTo(input);
  }

  @ParameterizedTest(name = "0이나 음수를 입력하는 경우 IllegalArgumentException 발생 테스트")
  @ValueSource(ints = {0, -1, -7, -9})
  public void validatedPositive_IllegalArgumentException_발생(int input) {
    assertThatThrownBy(() -> validatedPositive(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1회 이상만 입력 가능합니다.");
  }
}
