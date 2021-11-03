import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int devide(int a, int b) {
    return a / b;
  }

  public List<String> tokenizer(String input) {
    String invalidPattern = ".*[^0-9+\\-*/ ]+.*";
    if(input == null || input.isEmpty() || Pattern.matches(invalidPattern, input)) {
      throw new IllegalArgumentException();
    }
    return new ArrayList<>(Arrays.asList(input.split(" ")));
  }

  public int calculate(List<String> tokens) {
    int result = Integer.parseInt(tokens.get(0));
    String operator = "";
    for(String token : tokens.subList(1, tokens.size())) {
      if(!token.matches("[0-9]+")) {
        operator = token;
      } else {
        int temp = Integer.parseInt(token);
        switch (operator) {
          case "+":
            result += temp;
            break;
          case "-":
            result -= temp;
            break;
          case "*":
            result *= temp;
            break;
          case "/":
            result /= temp;
            break;
        }
      }
    }
    return result;
  }
}
