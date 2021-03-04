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

    result = Operation.findOperationByOperator(op).eval(lValue, rValue);
  }

}
