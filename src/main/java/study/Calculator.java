package study;

import java.util.ArrayDeque;
import java.util.Queue;

public class Calculator {

  private Integer result;
  private Queue<String> inputQueue;

  public Calculator(String inputValue) {
    inputQueue = new ArrayDeque<>();

    for (String str : inputValue.split(" ")) {
      inputQueue.offer(str);
    }
  }

  public Integer getResult() {
    return result;
  }

  public Calculator evalAll() {
    while (!inputQueue.isEmpty()) {
      eval();
    }
    return this;
  }

  private void eval() {
    if (result == null) {
      result = Integer.parseInt(inputQueue.poll());
    }

    Integer lValue = result;
    String op = inputQueue.poll();
    Integer rValue = Integer.parseInt(inputQueue.poll());

    result = chooseOperator(op, lValue, rValue);
  }

  private Integer chooseOperator(String op, Integer lValue, Integer rValue) {
    switch (op) {
      case "+":
        return add(lValue, rValue);
      case "-":
        return subtract(lValue, rValue);
      case "*":
        return multiply(lValue, rValue);
      case "/":
        return divide(lValue, rValue);
      default:
        return result;
    }
  }

  private Integer add(Integer lValue, Integer rValue) {
    return lValue + rValue;
  }

  private Integer subtract(Integer lValue, Integer rValue) {
    return lValue - rValue;
  }

  private Integer multiply(Integer lValue, Integer rValue) {
    return lValue * rValue;
  }

  private Integer divide(Integer lValue, Integer rValue) {
    return lValue / rValue;
  }

}
