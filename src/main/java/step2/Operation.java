package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {

    ADDITION("+", (number1, number2) -> number1 + number2)
  , SUBTRACTION("-", (number1, number2) -> number1 - number2)
  , DIVISION("/", (number1, number2) -> {
                                          if (number2 == 0) {
                                            throw new IllegalArgumentException("Cannot be divided by 0.");
                                          }
                                          return number1 / number2;
                                        })
  , MULTIPLICATION("*", (number1, number2) -> number1 * number2);

  private final String symbol;

  private final BiFunction<Integer, Integer, Integer> formula;

  Operation(String symbol, BiFunction<Integer, Integer, Integer> formula) {
    this.symbol = symbol;
    this.formula = formula;
  }

  public static Operation of(String param) {
    return Arrays.stream(Operation.values())
            .filter(operator -> operator.symbol.equals(param))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Not a valid operator."));
  }

  public int calculation(int number1, int number2) {
    return formula.apply(number1, number2);
  }

}
