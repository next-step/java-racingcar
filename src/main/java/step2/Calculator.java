package step2;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

  public int calculate(String formula) {
    ArrayList<String> operatorsAndoperands = parseAndValidate(formula);
    while (operatorsAndoperands.size() != 1) {
      operatorsAndoperands = calculateOneStep(operatorsAndoperands);
    }

    return Integer.parseInt(operatorsAndoperands.get(0));
  }

  private ArrayList<String> parseAndValidate(String formula) {
    if (formula == null) {
      throw new IllegalArgumentException();
    }

    String[] operatorsAndOperandsArray = formula.split(" ");
    int length = operatorsAndOperandsArray.length;

    if (length % 2 == 0) {
      throw new IllegalArgumentException();
    }

    return new ArrayList<>(Arrays.asList(operatorsAndOperandsArray));
  }

  private ArrayList<String> calculateOneStep(ArrayList<String> parsed) {
    int operand1 = Integer.parseInt(parsed.remove(0));
    String operator = parsed.remove(0);
    int operand2 = Integer.parseInt(parsed.remove(0));
    switch (operator) {
      case "+":
        parsed.add(0, Integer.toString(operand1 + operand2));
        break;

      case "-":
        parsed.add(0, Integer.toString(operand1 - operand2));
        break;

      case "*":
        parsed.add(0, Integer.toString(operand1 * operand2));
        break;

      case "/":
        parsed.add(0, Integer.toString(operand1 / operand2));
        break;

      default:
        throw new IllegalArgumentException();
    }

    return parsed;
  }
}
