import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

  private String enteredFormula;
  private List<String> splitFormulas = new ArrayList<>();

  private int lastIndex;

  //사용자 문자열 입력
  public void enterFormula(String userInput) {
    this.enteredFormula = userInput;
    this.splitFormulas = splitUserInput();
    this.lastIndex = this.splitFormulas.size() -1;
    validateFormula();
  }

  public int calculate() {
    return calculateFormula(this.splitFormulas);
  }

  private void validateFormula() {
    CalculatorValidator validator = new CalculatorValidator(splitFormulas, lastIndex);
    validator.validateUserInput();
  }

  //입력 Split
  private List<String> splitUserInput() {
    return Arrays.asList(this.enteredFormula.split(" "));
  }

  //계산수행
  private int calculateFormula(List<String> formulas) {
    int result = Integer.parseInt(formulas.get(0));
    for(int i = 0; i < lastIndex -1; i+=2) {
      result = calculate(result, formulas.get(i+1), Integer.parseInt(formulas.get(i+2)));
    }
    return result;
  }

  private int calculate(int prev, String operator, int next) {
    for (Operator op : Operator.values()) {
      if (operator.equals(op.symbol))
        return op.apply(prev, next);
    }
    throw new IllegalArgumentException("ERROR : 잘못된 연산자가 입력되었습니다.");
  }
}
