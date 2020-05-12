package step2;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringCalculator {

  private final static char numberStart = '0';
  private final static char numberEnd = '9';
  private final Stack<Integer> numberStack = new Stack();
  private final Stack<Character> operatorStack = new Stack();
  private String expression;
  private int lastPoint;
  private int result;
  private int pointer = 0;
  private String numberToken = "";
  private TokenType tokenType = TokenType.NUMBER;

  public void getExpression (String expression) {
    if (expression == null || expression.trim().equals("")) throw new IllegalArgumentException();
    this.expression = expression.trim().replaceAll(" ", ""); // 빈칸 제거
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

    if (this.tokenType.equals(TokenType.NUMBER)) {
      this.numberToken += token;
      int acc = 1;
      while (true) {
        if (this.pointer + acc >= this.lastPoint) break;
        token = this.expression.charAt(this.pointer + acc);
        if (!isNumber(token)) break;
        this.numberToken += token;
        acc += 1;
      }
      this.pointer += acc;
      this.tokenType = TokenType.OPERATOR;
    } else {
      if (!Operation.contains(token)) {
        throw new IllegalArgumentException(); // 숫자도 아니고, 사칙 연산 기호도 아닐 경우
      }
      calculate(token);
      this.pointer += 1;
      this.tokenType = TokenType.NUMBER;
    }
    getNextToken();

  }

  private void calculate (char nextOperator) {
    calculate();
    operatorStack.push(nextOperator);
    this.numberToken = "";
  }

  private void calculate () {
    int x = Integer.parseInt(this.numberToken);
    if (numberStack.size() > 0) {
      x = Operation.execute(operatorStack.pop(), numberStack.pop(), x);
    }
    numberStack.push(x);
  }

  private static boolean isNumber (char token) {
    return numberStart <= token && token <= numberEnd;
  }
}
