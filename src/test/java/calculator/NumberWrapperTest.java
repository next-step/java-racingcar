package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberWrapperTest {

  @Test
  @DisplayName("wrapper의 생성이 입력한대로 진행되었는지 확인한다.")
  void createTest() {
    //given
    int number = 1;

    //when
    NumberWrapper numberWrapper = new NumberWrapper(number);

    //then
    assertThat(numberWrapper).isEqualTo(new NumberWrapper(1));
  }

  @Test
  @DisplayName("String이 생성자의 인자로 주어질 경우 int로 파싱이 되는지 확인한다.")
  void createWithString() {
    //given
    String number = "3";

    //when
    NumberWrapper numberWrapper = new NumberWrapper(number);

    //then
    assertThat(numberWrapper).isEqualTo(new NumberWrapper(3));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("입력값이 null이거나 빈공백 일경우 IllegalArgumentException을 던진다.")
  void validCreation(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new NumberWrapper(input);
    });
  }
}
