package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {

    ADD("+", add())
  , SUB("-", sub())
  , DIV("/", div())
  , MUL("*", mul());

  private final String symbol;

  private final BiFunction<Integer, Integer, Integer> formula;

  Operation(String symbol, BiFunction<Integer, Integer, Integer> formula) {
    this.symbol = symbol;
    this.formula = formula;
  }

  public static Operation of(String param) {
    return Arrays.stream(Operation.values())
            .filter(o -> o.symbol.equals(param))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
  }

  public int calculation(int number1, int number2) {
    return formula.apply(number1, number2);
  }

  private static BiFunction<Integer, Integer, Integer> add() {
    return (number1, number2) -> number1 + number2;
  }

  private static BiFunction<Integer, Integer, Integer> sub() {
    return (number1, number2) -> number1 - number2;
  }

  private static BiFunction<Integer, Integer, Integer> div() {
    return (number1, number2) -> {
      if (number2 == 0)
        return 0;
      return number1 / number2;
    };
  }

  private static BiFunction<Integer, Integer, Integer> mul() {
    return (number1, number2) -> number1 * number2;
  }
}
