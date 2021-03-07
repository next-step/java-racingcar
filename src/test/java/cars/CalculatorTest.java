package cars;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
  /*
    테스트 목록 메모
      - scan str test
        - scanner 를 통해 입력된 str 은 split 했을때 배열의 길이가 홀수
        - split 된 배열의 홀수 번째는 숫자로 변형되어야함
        - split 된 짝수 번째는 + - * / 중 하나
      - add function test
        - 
      - substract function test
      - multiply function test
      - divide function test
  */

  @ParameterizedTest
  @NullSource
  @DisplayName("null str 이 들어왔을때 error 와 error.message 테스트")
  void checkNullStrTest(String str) {
    // System.out.println("str: " + str);
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> {
      calculator.checkNull(str);
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("null str");
  }

  @ParameterizedTest
  @EmptySource
  @DisplayName("empty str 이 들어왔을때 error 와 error.message 테스트")
  void checkEmptyStrTest(String str) {
    // System.out.println("str: " + str);
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> {
      calculator.checkEmptyStr(str);
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("empty str");
  }

  @ParameterizedTest
  @ValueSource(ints = { 2, 4 })
  @DisplayName("split 된 배열의 사이즈가 홀수가 아닐경우 error")
  void checkStrSizeTest(int size) {
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> {
      calculator.checkStrSize(size);
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("illegal size");
  }

  @ParameterizedTest
  @ValueSource(strings = { "/", "r" })
  @DisplayName("split 된 배열의 홀수 번째가 숫자가 아닐때 error 와 error.message 테스트")
  void checkNumberTest(String str) {
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> {
      calculator.checkNumber(str, 0);
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("illegal number");
  }

  @ParameterizedTest
  @ValueSource(strings = { "r", "3" })
  @DisplayName("split 된 배열의 짝수 번째가 숫자가 아닐때 error 와 error.message 테스트")
  void checkMarkTest(String str) {
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> {
      calculator.checkMark(str, 1);
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("illegal mark");
  }

  @ParameterizedTest
  @MethodSource("generateList")
  @DisplayName("계산기의 덧셈, 뺄셈, 곱셈, 나눗셈을 계산한다.")
  void calculateTest(String str, int result) {
    // System.out.println("str: " + str);
    // System.out.println("result: " + result);
    List<String> strList = Arrays.asList(str.split(" "));
    Calculator calculator = new Calculator();
    int total = calculator.calculate(strList);
    assertThat(result).isEqualTo(total);
  }

  private static Stream<Arguments> generateList() { // argument source method
    return Stream.of(Arguments.of("3 + 2", 5), Arguments.of("3 - 2", 1), Arguments.of("3 * 2", 6),
        Arguments.of("4 / 2", 2), Arguments.of("3 + 2 - 1 * 2 / 4", 2));
  }
}
