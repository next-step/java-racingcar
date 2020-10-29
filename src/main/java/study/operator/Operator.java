package study.operator;

import static study.exception.ExceptionMessage.CAN_NOT_DIVIDE_ZERO;
import static study.exception.ExceptionMessage.IS_NOT_OPERATOR;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

public enum Operator {
  PLUS_OPERATOR("+", (num1, num2) -> num1 + num2),
  MINUS_OPERATOR("-", (num1, num2) -> num1 - num2),
  MULTIPLICATION_OPERATOR("*", (num1, num2) -> num1 * num2),
  DIVISION_OPERATOR("/", (num1, num2) -> {
    if (num2 == 0) {
      throw new IllegalArgumentException(CAN_NOT_DIVIDE_ZERO);
    }
    return num1 / num2;
  });


  private String sign;
  private ToIntBiFunction operator;

  Operator(String sign, ToIntBiFunction<Integer, Integer> operator) {
    this.sign = sign;
    this.operator = operator;
  }

  public static final Map<String, Operator> operatorValues() {
    return Collections.unmodifiableMap(Arrays.stream(Operator.values())
        .collect(Collectors.toMap(operator -> operator.sign, Function.identity())));
  }

  private static Optional<Operator> getOperator(String sign) {
    return Optional.ofNullable(operatorValues().get(sign));
  }

  public static Operator get(String sign) {
    return getOperator(sign).orElseThrow(() -> new IllegalArgumentException(IS_NOT_OPERATOR));
  }

  public int compute(int num1, int num2) {
    return this.operator.applyAsInt(num1, num2);
  }

  public static int operatorCompute(int num1, int num2, String operator) {
    return Operator.get(operator).compute(num1, num2);
  }
}
