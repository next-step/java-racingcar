package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operator {

  private List<String> operators = new ArrayList<>();

  public Operator(String[] operators) {

    this.operators = separateOperator(operators);
  }

  private List<String> separateOperator(String[] separatedExpression) {
    return Arrays.stream(separatedExpression)
        .filter(value -> OperatorType.isOperator(value))
        .collect(Collectors.toList());
  }


  public String getOperator() {
    String operator = operators.get(0);
    operators.remove(0);
    return operator;
  }

  public int calculate(int leftValue, int rightValue) {
    return OperatorType.calculate(getOperator(), leftValue, rightValue);
  }
}
