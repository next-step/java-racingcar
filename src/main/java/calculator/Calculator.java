package calculator;

public class Calculator {
    private final int COUNT = 2;

  public int calculate(String text) {
    String[] split = text.split(" ");

    NumberWrapper result = new NumberWrapper(Integer.parseInt(split[0]));
    for (int i = COUNT; i < split.length; i+=COUNT) {
      result = operate(result, split[i-1], new NumberWrapper(Integer.parseInt(split[i])));
    }
    return result.getNumber();
  }

  public static NumberWrapper operate(NumberWrapper first, String operator, NumberWrapper second) {
    return Operator.of(operator).calculate(first, second);
  }


}
