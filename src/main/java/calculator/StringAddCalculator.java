package calculator;

public class StringAddCalculator {

  public static int splitAndSum(String input) {
    if(validate(input)) {
      return 0;
    }
    Delimiter delimiter = Delimiter.parse(input);
    String[] tokens = delimiter.split();
    Numbers numbers = Numbers.from(tokens);
    return numbers.sum();
  }

  private static boolean validate(String input){
    return input == null || input.isBlank();
  }

}
