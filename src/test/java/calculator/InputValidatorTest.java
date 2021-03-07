package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

  private InputValidator inputValidator;

  @BeforeEach
  void setUp() {
    inputValidator = new InputValidator();
  }

  @ParameterizedTest(name = "[Validator] validateInput 테스트 - {index}")
  @ValueSource(strings = {"", " "})
  void validateInputTest(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      inputValidator.validateInput(input);
    });
  }

  @ParameterizedTest(name = "[Validator] isBlank 테스트 - {index}")
  @ValueSource(strings = {" ", "2 + 3"})
  void isBlankTest() {
    assertThat(inputValidator.isBlank(" ")).isEqualTo(true);
    assertThat(inputValidator.isBlank("2 + 3")).isEqualTo(false);
  }

}
