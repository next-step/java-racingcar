package step2;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringCalculator {

  private final static List<Character> operators = "+-*/".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
  private final static char numberStart = '0';
  private final static char numberEnd = '9';
  private final Stack<Integer> numberStack = new Stack();
  private final Stack<Character> operatorStack = new Stack();
  private String expression;
  private int lastPoint;
  private int result;
  private int pointer = 0;
  private String numberToken = "";

  public void getExpression (String expression) {
    if (expression == null) throw new IllegalArgumentException();
    this.expression = expression.replaceAll(" ", ""); // 빈칸 제거
    this.lastPoint = this.expression.length();
    getNextToken();
    calculate();
    this.result = this.numberStack.pop();
  }

  public int getResult () {
    return this.result;
  }

  private void getNextToken () {
    if (this.pointer >= this.lastPoint) return;

    char token = this.expression.charAt(this.pointer);

    if (StringCalculator.operators.contains(token)) {
      calculate(token);
      this.pointer += 1;
      getNextToken();
    } else if (StringCalculator.isNumber(token)) {
      this.numberToken += token;
      this.pointer += 1;
      getNextToken();
    } else throw new IllegalArgumentException(); // 숫자도 아니고, 사칙 연산 기호도 아닐 경우

  }

  private void calculate (char nextOperator) {
    calculate();
    operatorStack.push(nextOperator);
    this.numberToken = "";
  }

  private void calculate () {
    int x = Integer.parseInt(this.numberToken);
    if (numberStack.size() > 0) {
      int y = numberStack.pop();
      char operator = operatorStack.pop();
      switch (operator) {
        case '+': x = y + x; break;
        case '-': x = y - x; break;
        case '*': x = y * x; break;
        case '/': x = y / x; break;
      }
    }
    numberStack.push(x);
  }

  private static boolean isNumber (char token) {
    return numberStart <= token && token <= numberEnd;
  }
}
