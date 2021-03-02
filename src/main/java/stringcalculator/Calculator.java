package stringcalculator;

import static stringcalculator.Validator.validateExpression;

import java.util.List;

public class Calculator {

  public int calculate(String expression) {
    validateExpression(expression);

    Extractor extractor = new Extractor(StringUtils.split(expression));
    List<Integer> numbers = extractor.getNumbers();
    List<Operator> operators = extractor.getOperators();
    int result = numbers.get(0);

    for (int i = 0; i < operators.size(); i++) {
      Operator operator = operators.get(i);
      Integer y = numbers.get(i + 1);

      result = operator.operate(result, y);
    }
    return result;
  }
}
