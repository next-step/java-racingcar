package study;

import static study.operator.Operator.operatorCompute;

import study.collection.InputNumberArr;
import study.collection.InputOperatorArr;

public class StringCalculator {

  public static int compute(String expression) {
    InputExpressionParser parsedExpression = new InputExpressionParser(expression);

    InputNumberArr inputNumberArr = parsedExpression.getInputNumberArr();
    InputOperatorArr inputOperatorArr = parsedExpression.getInputOperatorArr();

    int result = inputNumberArr.get(0);

    for (int i = 1; i < inputNumberArr.size(); i++) {
      int number = inputNumberArr.get(i);
      result = operatorCompute(result, number, inputOperatorArr.get(i - 1));
    }

    return result;
  }

}
