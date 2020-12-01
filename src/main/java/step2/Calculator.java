package step2;

public class Calculator {

  private final static String SPLIT_SPACE = " ";

  public int calculate(String input) {

    if(isEmpty(input)) {
      throw new IllegalArgumentException();
    }

    String[] splitInputArr = input.split(SPLIT_SPACE);

    int result = Integer.parseInt(splitInputArr[0]);
    for (int i = 1; i < splitInputArr.length; i += 2) {
      String operator = splitInputArr[i];
      int number = Integer.parseInt(splitInputArr[i+1]);
      result = getCalculateResult(operator, result, number);
    }

    return result;
  }

  private int getCalculateResult(String operator, int target, int number) {
    return CalculateOperator.calculate(operator, target, number);
  }

  private boolean isEmpty(String input) {
    return input == null || input.equals("");
  }

}
