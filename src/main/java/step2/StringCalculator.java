package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

  // TO-DO refactor list
  // 1-2. 유효한 문자열을 피연산자와 연산자로 나눠서 활용하도록 한다.

  public int calculator(String data) {
    if (data.equals("") && data == null) {
      throw new IllegalArgumentException("값을 입력해주세요.");
    }

    String replaceData = data.replaceAll(" ", "");
    List<String> datas = IntStream.range(0, replaceData.length())
            .mapToObj(i -> String.valueOf(replaceData.charAt(i)))
            .collect(Collectors.toList());

    validate(datas);

    int value = Integer.parseInt(datas.get(0));
    for (int i = 1; i <= datas.size() - 1; i++) {
      if (this.isOperator(datas.get(i)) && this.isNumeric(datas.get(i + 1))) {
        value = Calculator.calculate(datas.get(i), value, Integer.parseInt(datas.get(i + 1)));
      }
    }
    return value;
  }

  public boolean isNumeric(String data) {
    return Pattern.compile("(^[0-9]*$)").matcher(data).matches();
  }

  public boolean isOperator(String data) {
    List<String> operators = Arrays.asList("+", "-", "*", "/");
    return operators.contains(data);
  }

  public void validate(List<String> datas) {
    if (!this.isNumeric(datas.get(0))) {
      throw new IllegalArgumentException("첫번째 값이 유효하지 않습니다.");
    }

    if (this.isOperator(datas.get(datas.size() - 1))) {
      throw new IllegalArgumentException("유효하지 않은 연산입니다.");
    }
  }
}
