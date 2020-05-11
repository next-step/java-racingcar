import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * 문자열 계산기 구현해야하는 기능 목록
 *
 * 입력값 검증 - 널이거나 공백 체크 IllegalArgumentException throw
 * 문자열 분리 - 숫자와 연산기호
 * 연산기호 검증 - 사칙연산 기호가 아닌경우 체크
 * 덧셈 o
 * 뺠샘 o
 * 나눗셈 o
 * 곱셈 o
 * * */

// 궁금한부분: 테스트 코드는 구현하려는 로직에 대한 테스트만 있으면 되는지? 입력값을 받거나 이런거도 구현이 되어야하는건지. 구현한 테스트가 너무 단순한건지??

public class StringCalculatorTest {

  //private String input = "22 + 3 * 4 / 2";

  @Test
  @DisplayName("덧셈 테스트")
  void add(){
    int num1 = 3, num2 = 5;
    assertThat(num1+num2).isEqualTo(8);
  }


  @Test
  @DisplayName("뼬셈 테스트")
  void subtract(){
    int num1 = 8, num2 = 4;
    int result = num1 - num2;
    assertThat(result).isEqualTo(4);
  }

  @Test
  @DisplayName("나눗셈 테스트")
  void divide(){
    int num1 = 8, num2 = 4;
    int result = num1 / num2;
    assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("곱셈 테스트")
  void multiply(){
    int num1 = 8, num2 = 4;
    int result = num1 * num2;
    assertThat(result).isEqualTo(32);
  }

}