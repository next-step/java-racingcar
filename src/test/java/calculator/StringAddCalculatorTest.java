package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringAddCalculatorTest {

  private static StringAddCalculator stringAddCalculator;

  @BeforeAll
  static void createStringAddCalculator() {
    stringAddCalculator = new StringAddCalculator();
  }


  @Test
  @DisplayName("빈문자나 null 값이 들어가면 0을 반환한다")
  void emptyStringAndNullTest() {
    int emptyStringResult = stringAddCalculator.calculate("");
    int nullResult = stringAddCalculator.calculate(null);

    assertAll(
        () -> assertThat(emptyStringResult).isZero(),
        () -> assertThat(nullResult).isZero()
    );
  }

  @Test
  @DisplayName("숫자 하나를 문자열로 입력하면 해당 숫자를 반환한다")
  void oneNumberLetterTest() {
    int calculateResult = stringAddCalculator.calculate("1");

    assertThat(calculateResult).isEqualTo(1);
  }

  @Test
  @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다")
  void commaCalculateTest() {
    int calculateResult = stringAddCalculator.calculate("1,2,3,4");

    assertThat(calculateResult).isEqualTo(10);
  }

  @Test
  @DisplayName("숫자 두개를 콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다")
  void colonCalculateTest() {
    int calculateResult = stringAddCalculator.calculate("1:2:3:4");

    assertThat(calculateResult).isEqualTo(10);
  }

  @Test
  @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다")
  void minorNumberGetException() {
    assertThrows(RuntimeException.class,
            () -> stringAddCalculator.calculate("-1,2,3"), "음수는 계산 지원하지 않습니다");
  }

  @Test
  @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정 할 수 있다")
  void customSeparatorTest() {
    int calculateResult = stringAddCalculator.calculate("//a\n1a2a3");

    assertThat(calculateResult).isEqualTo(6);
  }

  @Test
  @DisplayName("//와 \n 문자 사이에 커스텀 구분자가 특수한 케이스 일 때도 split이 가능하다")
  void specialCustomSeparatorTest() {
    int result = stringAddCalculator.calculate("//*\n1*2*3");

    assertThat(result).isEqualTo(6);
  }

}