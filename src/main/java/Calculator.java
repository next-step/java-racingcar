import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

  private String enteredFormula;
  private List<String> splitFormulas = new ArrayList<>();

  private static final int FIRST_INDEX = 0;
  private int LAST_INDEX;

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

  //사용자 문자열 입력
  public void enterFormula(String userInput) {
    this.enteredFormula = userInput;
    validateUserInput();
  }

  public int calculate() {
    return calculateFormula(this.splitFormulas);
  }

  //입력 Split
  private List<String> splitUserInput() {
    return toList(this.enteredFormula.split(" "));
  }

  //문자열 List화
  private List<String> toList(String[] splitFormula) {
    return Arrays.asList(splitFormula);
  }

  //사용자 문자열 validate 구현
  private void validateUserInput() {
    this.splitFormulas = splitUserInput();
    this.LAST_INDEX = this.splitFormulas.size() -1;
    isValidateProperlySplit();
    isValidateHasStrangeCharacter();
    isValidateFirstAndLastElementInList(this.splitFormulas);
    isValidateHasNoRedundancy(this.splitFormulas);
  }

  private void isValidateProperlySplit() {
    if(LAST_INDEX <= 0) {
      throw new IllegalArgumentException("ERROR : 잘못된 계산식입니다.");
    }
  }

  private void isValidateHasStrangeCharacter() {
    for(String str : splitFormulas){
      isStrangeString(str);
    }
  }

  private void isStrangeString(String str) {
    if(!isNumeric(str) && str.length() > 1)
      throw new IllegalArgumentException("ERROR : 연산자 길이는 1을 초과할 수 없습니다.");
  }

  //계산식의 처음과 마지막이 숫자로 시작하는지 연산자로 시작하는지
  private void isValidateFirstAndLastElementInList(List<String> formulas) {
    if(isOperator(formulas.get(FIRST_INDEX)) && isOperator(formulas.get(LAST_INDEX))){
      throw new IllegalArgumentException("ERROR : 잘못된 계산식입니다.");
    }
  }

  //연산자가 맞는지 검증하는 함수
  private boolean isOperator(String symbol) {
    boolean result = false;
    for (Operator op : Operator.values()) {
      result = op.symbol.equals(symbol);
      if(result) break;
    }
    return result;
  }

  //문자와 숫자가 서로 중복되서 들어가있는지 않은지 (e.g 2 2 + 2 3 , + + 2 + 3)
  private void isValidateHasNoRedundancy(List<String> formulas) {
    for(int i = 0; i < LAST_INDEX; i++){
      isRedundancy(formulas.get(i), formulas.get(i + 1));
    }
  }

  //계산의 이전값과 다음값을 통해서 숫자가 중복되있거나 연산자가 중복되어 있는 경우
  private void isRedundancy(String prev, String next) {
    isPrevAndNextIsNumeric(prev, next);
    isPrevAndNextIsOperator(prev, next);
  }

  private void isPrevAndNextIsNumeric(String prev, String next) {
    boolean isPrevNumeric = isNumeric(prev);
    boolean isNextNumeric = isNumeric(next);
    if(isPrevNumeric == isNextNumeric) {
      throw new IllegalArgumentException("ERROR: 잘못된 계산식을 입력하셨습니다.");
    }
  }

  private boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }

  private void isPrevAndNextIsOperator(String prev, String next) {
    boolean isPrevOperator = isOperator(prev);
    boolean isNextOperator = isOperator(next);
    if(isPrevOperator == isNextOperator) {
      throw new IllegalArgumentException("ERROR: 잘못된 계산식을 입력하셨습니다.");
    }
  }

  //계산수행
  private int calculateFormula(List<String> formulas) {
    int result = Integer.parseInt(formulas.get(0));
    for(int i = FIRST_INDEX; i < LAST_INDEX -1; i+=2) {
      result = calculate(result, formulas.get(i+1), Integer.parseInt(formulas.get(i+2)));
    }
    return result;
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
    throw new IllegalArgumentException("ERROR : 잘못된 연산자가 입력되었습니다.");
  }

  private int multiple(int prev, int next) {
    return prev * next;
  }

  private int divide(int prev, int next) {
    return Math.floorDiv(prev, next);
  }

  private int sub(int prev, int next) {
    return prev - next;
  }

  private int sum(int prev, int next) {
    return prev + next;
  }
}
