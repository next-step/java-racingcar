package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
/**
 *
 * 문자열 계산기 구현해야하는 기능 목록
 * 기능 분리 힌트
 * 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
   * 덧셈
   * 뺄셈
   * 곱셈
   * 나눗셈
   * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
   * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
   * 사칙 연산을 모두 포함하는 기능 구현
 * 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
 * 반복적인 패턴을 찾아 반복문으로 구현한다.
 * 궁금한부분: 테스트 코드는 구현하려는 로직에 대한 테스트만 있으면 되는지? 입력값을 받거나 이런거도 구현이 되어야하는건지. 구현한 테스트가 너무 단순한건지?? 어디까지 분리해야하는거지??
 */
public class StringCalculatorTest {
  @Test
  @DisplayName("덧셈 테스트")
  void add() {
    int num1 = 3, num2 = 5;
    assertThat(num1 + num2).isEqualTo(8);
  }

  @Test
  @DisplayName("뼬셈 테스트")
  void subtract() {
    int num1 = 8, num2 = 4;
    int result = num1 - num2;
    assertThat(result).isEqualTo(4);
  }

  @Test
  @DisplayName("나눗셈 테스트")
  void divide() {
    int num1 = 8, num2 = 4;
    int result = num1 / num2;
    assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("곱셈 테스트")
  void multiply() {
    int num1 = 8, num2 = 4;
    int result = num1 * num2;
    assertThat(result).isEqualTo(32);
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("입력값 검증 - 널이거나 공백 입력시 IllegalArgumentException 발셍")
  void checkNullAndEmpty(String input) throws IllegalAccessException {
    assertThatThrownBy(() -> {
      if ("".equals(input) || null == input) {
        throw new IllegalArgumentException();
      }
    }).isInstanceOf(IllegalArgumentException.class);

  }

  @Test
  @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 발생")
  void checkOperation() {
    String operation = "$";
    assertThatThrownBy(() -> {
      if (!("+".equals(operation) || "-".equals(operation) || "/".equals(operation) || "*"
          .equals(operation))) {
        throw new IllegalArgumentException();
      }
    }).isInstanceOf(IllegalArgumentException.class);

  }
}