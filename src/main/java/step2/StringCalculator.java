package step2;

import java.util.Stack;

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
    if (expression == null) throw new IllegalArgumentException(CalculatorError.ARGS_NULL);
    if (expression.trim().equals("")) throw new IllegalArgumentException(CalculatorError.ARGS_EMPTY);
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
      this.pointer += scanNumber();
    } else {
      if (!Operation.contains(token)) {
        // 연산자 오류
        throw new IllegalArgumentException(CalculatorError.INVALID_OPERATOR);
      }
      calculate(token);
      this.pointer += 1;
    }
    toggleTokenType();
    getNextToken();

  }

  private int scanNumber () {
    int acc = 1;
    char token;
    while (this.pointer + acc >= this.lastPoint) {
      token = this.expression.charAt(this.pointer + acc);
      if (!isNumber(token)) break;
      this.numberToken += token;
      acc += 1;
    }
    return acc;
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

  private void toggleTokenType () {
    this.tokenType = this.tokenType.equals(TokenType.NUMBER) ? TokenType.OPERATOR : TokenType.NUMBER;
  }

  private static boolean isNumber (char token) {
    return numberStart <= token && token <= numberEnd;
  }
}
