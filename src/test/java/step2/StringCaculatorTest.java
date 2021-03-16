package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCaculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("문자열계산기의 예외처리 확인")
  public void 문자열계산기_예외처리() {
    // null 입력
    assertThatIllegalArgumentException().isThrownBy(()-> calculator.getResult("")).withMessage("계산식이 잘못 되었습니다.");

    // 잘못된 사칙연산부호 입력
    assertThatIllegalArgumentException().isThrownBy(()-> calculator.getResult("1 $ 3")).withMessage("사칙연산 기호가 아닙니다.");
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2 = 10", "1 + 5 / 3 * 7 = 14"}, delimiter = '=')
  @DisplayName("문자열계산기의 계산결과 검사")
  public void 문자열계산기_계산결과(String formula, int expected) {
    // 계산값 확인
    assertThat(calculator.getResult(formula)).isEqualTo(expected);
  }
}
