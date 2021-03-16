package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCaculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("문자열계산기의 동작 및 예외처리 확인")
  public void 문자열계신기_테스트() {

    // null 입력
    assertThatIllegalArgumentException().isThrownBy(()-> calculator.caculate("")).withMessage("계산식이 잘못 되었습니다.");

    // 잘못된 사칙연산 입력
    assertThatIllegalArgumentException().isThrownBy(()-> calculator.caculate("1 $ 3")).withMessage("사칙연산 기호가 아닙니다.");

    // 계산값 확인
    assertThat(calculator.caculate("2 + 3 * 4 / 2")).isEqualTo(10);
  }
}
