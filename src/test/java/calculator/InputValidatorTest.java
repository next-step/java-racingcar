package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

  @ParameterizedTest(name = "[Validator] validateInput 테스트 - {index}")
  @ValueSource(strings = {"", " "})
  void validateInputTest(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      InputValidator.validateInput(input);
    });
  }

  @Test
  @DisplayName(("[Validator] isEmpty 테스트"))
  void isEmptyTest() {
    assertThat(InputValidator.isEmpty("")).isEqualTo(true);
    assertThat(InputValidator.isEmpty("2 + 3")).isEqualTo(false);
  }

  @Test
  @DisplayName(("[Validator] isBlank 테스트"))
  void isBlankTest() {
    assertThat(InputValidator.isBlank(" ")).isEqualTo(true);
    assertThat(InputValidator.isBlank("2 + 3")).isEqualTo(false);
  }

}
