package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.validator.Validator;

public class ValidatorTest {

  @DisplayName("0보다 큰 수를 입력했을때, 에러가 발생하지 않는지 테스트")
  @Test
  void validator() {
    // given
    int value = 3;

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorNumber(value);
    });

    // then
    assertThat(thrown).isEqualTo(null);
  }

  @DisplayName("0을 입력했을때, 에러가 하는지 테스트")
  @Test
  void validatorException() {
    // given
    int value = 0;

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorNumber(value);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

}
