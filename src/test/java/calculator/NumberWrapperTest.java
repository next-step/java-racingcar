package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberWrapperTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 5, 10, 20, 16})
  @DisplayName("wrapper의 생성자를 통해 int 값을 가진 객체로 생성이 되었는지 확인한다.")
  void createTest(int input) {
    assertThat( new NumberWrapper(input).getNumber()).isEqualTo(input);
  }

  @ParameterizedTest
  @ValueSource(strings = {"3", "5", "10", "20", "8"})
  @DisplayName("String이 생성자의 인자로 주어질 경우 int로 파싱이 되는지 확인한다.")
  void createWithString(String input) {
    assertThat(new NumberWrapper(input).getNumber()).isEqualTo(Integer.parseInt(input));
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
