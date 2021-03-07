package calculator;

public class Calculator {

  final String DELIMITER = " ";

  public int calculate(String input) {
    InputValidator inputValidator = new InputValidator();
    inputValidator.validateInput(input);

    String[] calcArr = input.split(DELIMITER);
    int result = Integer.parseInt(calcArr[0]);

    for (int i = 1; i < calcArr.length; i += 2) {
      result = Operator.calculate(result, Integer.parseInt(calcArr[i + 1]), calcArr[i]);
    }

    return result;
  }

}
