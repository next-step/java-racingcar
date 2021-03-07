package cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class Calculator {
  public static void main(String[] args) {
    System.out.println("Calculator start");
    Calculator calculator = new Calculator();
    Scanner scanner = new Scanner(System.in);
    String str = null;
    while (true) {
      try {
        str = scanner.nextLine();
        calculator.checkNull(str);
        // String[] strArray = str.split(" ");
        List<String> strList = Arrays.asList(str.split(" "));
        calculator.checkStr(strList);
        int num = calculator.calculate(strList);
        System.out.println("result: " + num);
      } catch (IllegalArgumentException e) {
        System.out.println("error message: " + e.getMessage());
      }
    }
  }

  void checkNull(String str) {
    if (str == null)
      throw new IllegalArgumentException("null str error");
  }

  void checkStr(List<String> strList) {
    int index = 0;
    checkStrSize(strList.size());
    for (String str : strList) {
      checkEmptyStr(str);
      checkNumber(str, index);
      checkMark(str, index);
      index++;
    }
  }

  void checkStrSize(int size) {
    if (size % 2 == 0)
      throw new IllegalArgumentException("illegal size error");
  }

  void checkEmptyStr(String str) {
    if (str == "")
      throw new IllegalArgumentException("empty str error");
  }

  void checkNumber(String str, int index) {
    // split 된 홀수번째 str 가 int 인지 체크
    if (index % 2 == 1)
      return;
    try {
      Integer.parseInt(str);
    } catch (Exception e) {
      throw new IllegalArgumentException("illegal number error");
    }
  }

  void checkMark(String str, int index) {
    // split 된 짝수 번째 str 가 사칙연산 기호인지 체크
    List<String> marks = Arrays.asList("+", "-", "*", "/");
    if (index % 2 == 0)
      return;
    if (!marks.contains(str))
      throw new IllegalArgumentException("illegal mark error");
  }

  int calculate(List<String> strList) {
    if (strList.size() < 3)
      return Integer.parseInt(strList.get(0));

    List<String> copyedList = new ArrayList<>(strList);
    int a = Integer.parseInt(copyedList.remove(0));
    String mark = copyedList.remove(0);
    int b = Integer.parseInt(copyedList.remove(0));

    switch (mark) {
      case "+":
        copyedList.add(0, Integer.toString(add(a, b)));
        break;
      case "-":
        copyedList.add(0, Integer.toString(substract(a, b)));
        break;
      case "*":
        copyedList.add(0, Integer.toString(multiply(a, b)));
        break;
      case "/":
        copyedList.add(0, Integer.toString(divide(a, b)));
        break;
    }
    return calculate(copyedList);
  }

  int add(int a, int b) {
    return a + b;
  }

  int substract(int a, int b) {
    return a - b;
  }

  int multiply(int a, int b) {
    return a * b;
  }

  int divide(int a, int b) {
    return a / b;
  }
}