package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

  @Test
  @DisplayName("문자열 계산기 테스트")
  void calculator() {
    assertThat(calculator("2")).isEqualTo(2);
    assertThat(calculator("2 + 3")).isEqualTo(5);
    assertThat(calculator("2 + 3 * 4")).isEqualTo(20);
    assertThat(calculator("2 + 3 * 4 / 2")).isEqualTo(10);
    assertThat(calculator("2 + 3 * 4 / 2 - 1")).isEqualTo(9);
  }

  @ParameterizedTest
  @MethodSource( { "getBlankString", "getInvalidInputString" })
  @DisplayName("입력 값 예외 테스트 - 입력 값이 null or 빈 공백 문자열 or 사칙연산 기호가 아닌 경우 ")
  void inValidInputString(final String input) {
    assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> checkValidInputString(input));
  }

  private static Stream<String> getBlankString() {
    return Stream.of("", "  ", null);
  }

  private static Stream<String> getInvalidInputString() {
    return Stream.of("1 . 1", "1 ^ 1");
  }

  private int calculator(String input) {
    checkValidInputString(input);

    int result = 0;
    String[] array = input.split(" ");

    String symbol = "";
    for (int i = 0; i < array.length; i++) {
      String str = array[i];
      boolean isNumber = i % 2 == 0;
      if (isNumber) {
        int number = Integer.parseInt(str);
        if (result == 0)
          result = number;

        result = operation(symbol, result, number);
      }
      symbol = str;
    }
    return result;
  }

  private void checkValidInputString(String input) {
    if (isBlank(input) || !isValidOperationSymbol(input))
      throw new IllegalArgumentException();
  }

  private boolean isValidOperationSymbol(String input) {
    final String[] OPERATION_SYMBOLS = new String[]{ "+", "-", "*", "/" };
    return getOperationSymbolList(input)
            .stream()
            .map(String::valueOf)
            .allMatch(symbol -> Arrays.stream(OPERATION_SYMBOLS)
                    .anyMatch(valid -> valid.equals(symbol)));
  }

  private List<String> getOperationSymbolList(String input) {
    final String[] INPUT_ARRAY = input.split(" ");
    return getList(INPUT_ARRAY, i -> i % 2 != 0, i -> INPUT_ARRAY[i]);
  }

  private <R> List<R> getList(String[] inputArray, IntPredicate predicate, Function<Integer, R> mapper) {
    return IntStream.range(0, inputArray.length)
            .filter(predicate)
            .boxed()
            .map(mapper)
            .collect(Collectors.toList());
  }

  private boolean isBlank(String input) {
    return input == null || input.trim().isEmpty();
  }

  private int operation(String symbol, int result, int number) {
    switch (symbol) {
      case "+": return add(result, number);
      case "-": return sub(result, number);
      case "/": return div(result, number);
      case "*": return multiply(result, number);
      default: return result;
    }
  }

  private int div(int result, int number) {
    return result / number;
  }

  private int multiply(int result, int number) {
    return result * number;
  }

  private int sub(int result, int number) {
    return result - number;
  }

  private int add(int result, int number) {
    return result + number;
  }
}
