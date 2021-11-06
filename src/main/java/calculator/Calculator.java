package calculator;

public class Calculator {
    private final int COUNT = 2;
    private final int INCREASE_COUNT = 2;
    private final String BLANK = " ";

  public int calculate(String text) {
    String[] split = text.split(BLANK);

    String firstNumber = split[0];
    NumberWrapper firstFactor = new NumberWrapper(firstNumber);
    for (int i = COUNT; i < split.length; i += INCREASE_COUNT) {
      String operator = split[i - 1];
      NumberWrapper secondFactor = new NumberWrapper(split[i]);
      firstFactor = Operator.of(operator)
                            .calculate(firstFactor,secondFactor);
    }
    return firstFactor.getNumber();
  }

}
