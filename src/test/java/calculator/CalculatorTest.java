package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
  // private method는 테스트 하지 않아도 된다.

  @Test
  void null_값() {
    int result = Calculator.calculate(null); // 구현을 안했어도 일단 적고 컴파일 안되도 신경쓰지 마라
    assertThat(result).isEqualTo(0); // input과 output을 검증하는 로직이 항상 있어야한다.
  }

  @Test
  void 문자_하나(){
    int result = Calculator.calculate("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  void 컴마_구분자(){
    int result = Calculator.calculate("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  void 콜론_구분자(){
    int result = Calculator.calculate("1:2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  void 커스텀_구분자(){
    int result = Calculator.calculate("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  void 음수_입력의_경우_RuntimeException(){
    assertThatThrownBy( () -> Calculator.calculate("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}
