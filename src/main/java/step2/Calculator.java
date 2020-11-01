package step2;

import java.util.function.BiFunction;

public enum Calculator {
 ADD("+", (first, second) -> first + second),
 SUBTRACT("-", (first, second) -> first - second),
 MULTIPLY("*", (first, second) -> first * second),
 DIVISION("-", (first, second) -> first / second);

 String operator;
 BiFunction<Integer, Integer, Integer> values;

 Calculator(String operator, BiFunction<Integer, Integer, Integer> values) {
  this.operator = operator;
  this.values = values;
 }

 public int calculate(String operator, int first, int second) {
  switch (operator) {
   case "+":
    return ADD.values.apply(first, second);
   case "-":
    return SUBTRACT.values.apply(first, second);
   case "*":
    return MULTIPLY.values.apply(first, second);
   case "/":
    return DIVISION.values.apply(first, second);
   default:
    throw new IllegalArgumentException("유효하지 않은 연산자입니다. " + operator);
  }
 }
}
