package racing.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameLengthValidationStrategyTest {

  @Test
  @DisplayName("입력 문자열이 비었을 경우 false 를 반환")
  void emptyValidationTest() {
    NameValidationStrategy nameValidationStrategy = new NameLengthValidationStrategy();

    assertThat(nameValidationStrategy.isValid("")).isEqualTo(false);
  }

  @ParameterizedTest
  @DisplayName("입력 문자열이 기준 이하인 경우 true 를 반환")
  @ValueSource(strings = {"a", "b", "abcde", "mytestcarcar", "hihisososo"})
  void validationTest(String name) {
    NameValidationStrategy nameValidationStrategy = new NameLengthValidationStrategy();

    assertThat(nameValidationStrategy.isValid(name)).isEqualTo(
        name.length() <= NameLengthValidationStrategy.LENGTH_LIMIT);
  }
}