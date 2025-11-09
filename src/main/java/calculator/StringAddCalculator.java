package calculator;

public class StringAddCalculator {

  public static int splitAndSum(String input) {
    if(validate(input)) {
      return 0;
    }
    InputContext inputContext = new InputContext(input);
    String[] tokens = inputContext.split();
    Numbers numbers = new Numbers(tokens);
    return numbers.sum();
  }

  private static boolean validate(String input){
    return input == null || input.isBlank();
  }

}
