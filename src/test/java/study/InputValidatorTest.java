package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *  Input값 검증 부분 테스트 케이스
 */
public class InputValidatorTest {

  @Test
  @DisplayName("입력 값이 null일 때")
  public void checkInputNullTest() {
    final String testData = null;

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new InputValidator(testData))
        .withMessageMatching("Input cannot be null.");
  }

  @Test
  @DisplayName("입력 값이 빈칸일 때")
  public void checkInputBlankTest() {
    final String testData = " ";

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new InputValidator(testData).checkHasBlank())
        .withMessageMatching("Input cannot be blank.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"2 $ 3", "4 ~ 1 + 3", "9 - 0 / 3 $ 2"})
  @DisplayName("사칙 연산 기호가 아닌 경우")
  public void checkInputHasValidOperatorTest(final String testData) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new InputValidator(testData).checkHasWrongOperator())
        .withMessageMatching("Input contains wrong operators.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1 + 2", "5 - 3 * 2", "9 - 4 * 2 * 2"})
  @DisplayName("사칙 연산을 모두 포함하는 경우 확인")
  public void checkInputHasAllOperatorTest(final String testData) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new InputValidator(testData).checkHasAllOperator())
        .withMessageMatching("Some operators are missing.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1 + 2 - 6 * 4 / 3", "7 * 2 + 6 - 4 / 3", "1 / 2 + 6 * 4 - 3"})
  @DisplayName("입력 값이 모든 조건을 만족하는 경우 확인")
  public void checkInputIsPerfect(final String testData) {
    String validData = new InputValidator(testData)
        .checkHasBlank()
        .checkHasWrongOperator()
        .checkHasAllOperator()
        .getValue();

    assertThat(validData).isEqualTo(testData);
  }
}
