package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    validator = new Validator();
  }

  @ParameterizedTest(name = "[Validator] validateInput 테스트 - {index}")
  @ValueSource(strings = {"", " "})
  void validateInputTest(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      validator.validateInput(input);
    });
  }

  @ParameterizedTest(name = "[Validator] isEmpty 테스트 - {index}")
  @ValueSource(strings = {"", "2 + 3"})
  void isEmptyTest(String input) {
    assertThat(validator.isEmpty(input)).isEqualTo(true);
    assertThat(validator.isEmpty(input)).isEqualTo(false);
  }

  @ParameterizedTest(name = "[Validator] isBlank 테스트 - {index}")
  @ValueSource(strings = {" ", "2 + 3"})
  void isBlankTest() {
    assertThat(validator.isBlank(" ")).isEqualTo(true);
    assertThat(validator.isBlank("2 + 3")).isEqualTo(false);
  }

}
