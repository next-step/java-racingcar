package step2;

import static step2.CalculatorUtil.checkOperator;
import static step2.CalculatorUtil.isNumber;

import java.util.ArrayList;
import java.util.List;

public class StringSeparator {

  private final String[] expression;
  private final List<Integer> numbers;
  private final List<String> symbols;

  StringSeparator(String[] expression) {
    this.expression = expression;
    this.numbers = new ArrayList<>();
    this.symbols = new ArrayList<>();

    separate(expression);
  }

  public void separate(String[] expression) {
    for (String input : expression) {
      if (isNumber(input)) {
        numbers.add(Integer.valueOf(input));
      } else {
        symbols.add(checkOperator(input));
      }
    }
  }

  public List<String> getSymbols() {
    return symbols;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
