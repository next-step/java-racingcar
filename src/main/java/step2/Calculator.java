package step2;

public class Calculator {

  private final static String SPLIT_SPACE = " ";

  public static int calculate(String input) {

    valid(input);

    String[] splitInputArr = input.split(SPLIT_SPACE);

    int result = Integer.parseInt(splitInputArr[0]);
    for (int i = 1; i < splitInputArr.length; i += 2) {
      CalculateOperator operator = CalculateOperator.valueOfOperator(splitInputArr[i]);
      int number = Integer.parseInt(splitInputArr[i + 1]);
      result = operator.calculate(result, number);
    }

    return result;
  }

  private static void valid(String input) {
    if(input == null || input.equals("")) {
      throw new IllegalArgumentException();
    }
  }

}
