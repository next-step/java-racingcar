import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class Calculator {

  private String enteredFormula;
  private int enteredFormulaLength;

  private static final int FIRST_INDEX = 0;
  public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return super.toString();
    }
  }

  //TODO : 사용자 문자열 입력
  public void enterFormula(String userInput) {
    this.enteredFormula = userInput;
    isValidFormula();
  }

  //TODO : 입력 Split
  private String[] splitUserInput() {
    return this.enteredFormula.split(" ");
  }

  //TODO : 사용자 문자열 validate 구현
  private void isValidFormula() {
    String[] splitFormula = splitUserInput();
    List<String> formulas = toList(splitFormula);
    this.enteredFormulaLength = splitFormula.length;

    isValidateFirstAndLastElementInList(formulas);
    isValidateHasNoRedundancy(formulas);
    calculateFormula(formulas);
  }

  //TODO : 문자열 List화
  public List<String> toList(String[] splitFormula) {
    return Arrays.asList(splitFormula);
  }

  //TODO : 계산식의 처음과 마지막이 숫자로 시작하는지 연산자로 시작하는지
  private void isValidateFirstAndLastElementInList(List<String> formulas) {
    if(isOperator(formulas.get(FIRST_INDEX)) && isOperator(formulas.get(enteredFormulaLength))){
      throw new IllegalArgumentException("잘못된 계산식입니다.");
    }
  }

  private boolean isOperator(String symbol) {
    boolean result = false;
    for (Operator op : Operator.values()) {
      result = op.symbol.equals(symbol);
      if(result) break;
    }
    return result;
  }

  //TODO : 문자와 숫자가 서로 중복되서 들어가있는지 않은지 (e.g 2 2 + 2 3 , + + 2 + 3)
  private void isValidateHasNoRedundancy(List<String> formulas) {
    for(int i = 0; i < enteredFormulaLength-1; i++){
      isRedundancy(formulas.get(i), formulas.get(i + 1));
    }
  }

  //TODO : 계산의 이전값과 다음값을 통해서 숫자가 중복되있거나 연산자가 중복되어 있는 경우 체
  private void isRedundancy(String prev, String next) {
    isPrevAndNextIsNumeric(prev, next);
    isPrevAndNextIsOperator(prev, next);
  }

  private void isPrevAndNextIsNumeric(String prev, String next) {
    boolean isPrevNumeric = isNumeric(prev);
    boolean isNextNumeric = isNumeric(next);
    if(isPrevNumeric == isNextNumeric) {
      throw new IllegalArgumentException("잘못된 계산식을 입력하셨습니다.");
    }
  }

  private boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }

  private void isPrevAndNextIsOperator(String prev, String next) {
    boolean isPrevOperator = isOperator(prev);
    boolean isNextOperator = isOperator(next);
    if(isPrevOperator == isNextOperator) {
      throw new IllegalArgumentException("잘못된 계산식을 입력하셨습니다.");
    }
  }

  //TODO : 계산수행 2,*,3,+,1
  private void calculateFormula(List<String> formulas) {
    int result = Integer.parseInt(formulas.get(0));
    for(int i = FIRST_INDEX; i < enteredFormulaLength -2; i+=2) {
      result = calculate(result, formulas.get(i+1), Integer.parseInt(formulas.get(i+2)));
    }
    System.out.println(result);
  }

  private int calculate(int prev, String operator, int next) {
    if(operator.equals("+"))
      return sum(prev, next);
    if(operator.equals("-"))
      return sub(prev, next);
    if(operator.equals("*"))
      return multiple(prev, next);
    if(operator.equals("/"))
      return divide(prev,next);
    throw new IllegalArgumentException("잘못된 계산식 입니다.");
  }

  private int multiple(int prev, int next) {
    return prev * next;
  }

  private int divide(int prev, int next) {
    return prev / next;
  }

  private int sub(int prev, int next) {
    return prev - next;
  }

  private int sum(int prev, int next) {
    return prev + next;
  }
}
