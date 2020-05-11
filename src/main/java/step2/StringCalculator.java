package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

  private final static char[] Operators = { '+', '-', '*', '/' };
  private final List<String> stack = new ArrayList();

  public StringCalculator(String expression) {
    if (expression == null) throw new IllegalArgumentException();
    expressionScan(expression);
  }

  public void expressionScan (String expression) {
    System.out.println(expression.chars().boxed());
  }

}
