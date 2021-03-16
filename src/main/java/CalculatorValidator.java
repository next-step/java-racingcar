import java.util.List;

public class CalculatorValidator {

  private final List<String> formula;
  private final int lastIndex;

  public CalculatorValidator(List<String> formula, int lastIndex) {
    this.formula = formula;
    this.lastIndex = lastIndex;
  }

  //사용자 문자열 validate 구현
  public void validateUserInput() {
    formulaIsProperlySplit(formula.size());
    hasStrangeCharacter(formula);
    validateFirstAndLastElementInFormula(formula);
    hasRedundancy(formula);
  }

  private void formulaIsProperlySplit(int size) {
    if(size <= 0) {
      throw new IllegalArgumentException("ERROR : 잘못된 계산식입니다.");
    }
  }

  private void hasStrangeCharacter(List<String> formula) {
    for(String str : formula){
      isStrangeString(str);
    }
  }

  private void isStrangeString(String str) {
    if(!isNumeric(str) && str.length() > 1)
      throw new IllegalArgumentException("ERROR : 연산자 길이는 1을 초과할 수 없습니다.");
  }

  //계산식의 처음과 마지막이 숫자로 시작하는지 연산자로 시작하는지
  private void validateFirstAndLastElementInFormula(List<String> formulas) {
    if(isOperator(formulas.get(0)) && isOperator(formulas.get(lastIndex))){
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
  private void hasRedundancy(List<String> formulas) {
    for(int i = 0; i < lastIndex; i++){
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
}
