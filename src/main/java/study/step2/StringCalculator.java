package study.step2;


public class StringCalculator {

  public double calculate(String inputText) {
    String tokens[] = Utils.getTokens(inputText);

    double result = Double.parseDouble(tokens[0]);

    for (int i = 1; i < tokens.length; i += 2) {
      Operands operands = new Operands(result, tokens[i + 1]);

      String operator = tokens[i];

      result = Operation.calculate(operator, operands);
    }

    return result;
  }



}
