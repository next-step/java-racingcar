package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

  private final static List<Character> operators = "+-*/".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
  private final static int numberStart = '0';
  private final static int numberEnd = '9';
  private final List<String> stack = new ArrayList();
  private final String expression;
  private int pointer = 0;
  private int lastPoint;

  public StringCalculator(String expression) {
    if (expression == null) throw new IllegalArgumentException();
    this.expression = expression.replaceAll(" ", ""); // 빈칸 제거
    this.lastPoint = this.expression.length();
    // getNextToken();
  }

  public void getNextToken () {
    if (this.pointer >= this.lastPoint) return;

    char token = this.expression.charAt(this.pointer);

    if (StringCalculator.operators.contains(token)) {
      operatorPush(token);
      this.pointer += 1;
      getNextToken();
    }

    if (StringCalculator.isNumber(token)) {
      this.pointer += numberPush();
      getNextToken();
    }

    throw new IllegalArgumentException(); // 숫자도 아니고, 사칙 연산 기호도 아닐 경우

  }

  void operatorPush (char operator) {

  }

  int numberPush () {
    while ()
  }

  private static boolean isNumber (char token) {
    return numberStart <= token && token <= numberEnd;
  }
}
