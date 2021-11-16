package calculator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

  private final Queue<String> expression = new LinkedList<>();

  public Calculator(String input) {
    if (input == null || input.trim().equals("")) {
      throw new IllegalArgumentException();
    }

    Collections.addAll(expression, input.split(" "));
  }

  public int calculate() {
    MyNumber result = new MyNumber(expression.poll());

    while (!expression.isEmpty()) {
      Operator operator = Operator.of(expression.poll());
      MyNumber target = new MyNumber(expression.poll());

      result = operator.operate(result, target);
    }

    return result.getNumber();
  }
}
