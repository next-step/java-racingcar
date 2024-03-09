package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
  // private method는 테스트 하지 않아도 된다.

  @Test
  @DisplayName("null을 입력한 경우 0을 반환 한다")
  void null_값() {
    int result = Calculator.calculate(null); // 구현을 안했어도 일단 적고 컴파일 안되도 신경쓰지 마라
    assertThat(result).isEqualTo(0); // input과 output을 검증하는 로직이 항상 있어야한다.
  }

  @Test
  @DisplayName("문자 하나를 입력하면 값 그대로 전달한다")
  void 문자_하나(){
    int result = Calculator.calculate("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("쉼표 구분자를 사용하여 숫자 두개를 입력하면 두 숫자의 합을 반환한다")
  void 컴마_구분자(){
    int result = Calculator.calculate("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("콜론를 사용하여 숫자를 입력하면 숫자들의 합을 반환한다")
  void 콜론_구분자(){
    int result = Calculator.calculate("1:2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("커스텀 구분자가 입력에 포함되면 커스텀 구분자로 숫자를 나눠 이들의 합을 반환한다")
  void 커스텀_구분자(){
    int result = Calculator.calculate("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("음수를 입력하면 RuntimeException을 반환한다")
  void 음수_입력의_경우_RuntimeException(){
    assertThatThrownBy( () -> Calculator.calculate("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}
