package step2;

import org.junit.platform.commons.util.StringUtils;
import step2.validate.StringCalculatorValid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
  private final StringCalculatorValid valid = new StringCalculatorValid();

  public int calculator(String data) {
    if (StringUtils.isBlank(data)) {
      throw new IllegalStateException("값을 입력해주세요.");
    }

    String replaceData = data.replaceAll(" ", "");
    List<String> datas = IntStream.range(0, replaceData.length())
            .mapToObj(i -> String.valueOf(replaceData.charAt(i)))
            .collect(Collectors.toList());

    if (!valid.isNumeric(datas.get(0))) {
      throw new IllegalStateException("첫번째 값이 유효하지 않습니다.");
    }

    int result = Integer.parseInt(datas.get(0));
    for (int i = 1; i <= datas.size() - 1; i++) {
      if (i == datas.size() - 1 && valid.isOperator(datas.get(datas.size() - 1))) {
        continue;
      }
      if (!valid.isOperator(datas.get(i)) || !valid.isNumeric(datas.get(i + 1))) {
        continue;
      }
      result = getCalculator(result, datas.get(i), Integer.parseInt(datas.get(i + 1)));
    }
    return result;
  }

  public int getCalculator(int first, String operator, int second) {
    switch (operator) {
      case "+":
        return add(first, second);
      case "-":
        return subtract(first, second);
      case "*":
        return multiply(first, second);
      case "/":
        return division(first, second);
      default:
        throw new IllegalStateException("유효하지 않은 연산자입니다. " + operator);
    }
  }

  public int add(int first, int second) {
    return first + second;
  }

  public int subtract(int first, int second) {
    return first - second;
  }

  public int multiply(int first, int second) {
    return first * second;
  }

  public int division(int first, int second) {
    return first / second;
  }
}
