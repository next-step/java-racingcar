package step2;

import java.util.ArrayList;
import java.util.Scanner;

public class StringCalculator {

  public static int add(int num1, int num2) {
    return num1 + num2;
  }

  public static int subtract(int num1, int num2) {
    return num1 - num2;
  }

  public static int divide(int num1, int num2) {
    return num1 / num2;
  }

  public static int multiply(int num1, int num2) {
    return num1 * num2;
  }

  public static ArrayList<Integer> getNumbers(String[] data) {
    ArrayList<Integer> numbers = new ArrayList<>();
    for (String s : data) {
      if (isNumber(s)) {
        numbers.add(Integer.parseInt(s));
      }
    }
    return numbers;
  }

  public static ArrayList<String> getOperators(String[] data) {
    ArrayList<String> operators = new ArrayList<>();
    for (String s : data) {
      if (!isNumber(s)) {
        checkOperator(s);
        operators.add(s);
      }
    }
    return operators;
  }

  public static void checkOperator(String data) {
    if (!("+".equals(data) || "-".equals(data) || "/".equals(data) || "*"
        .equals(data))) {
      throw new IllegalArgumentException();
    }
  }

  public static boolean isNumber(String data) {
    try {
      Integer.parseInt(data);
      return true;
    } catch (NumberFormatException ne) {
      return false;
    }
  }

  public static int calculate(ArrayList<Integer> number, ArrayList<String> operator) {
    int result = number.get(0);
    int operatorIdx = 0;
    for (int i = 1; i < number.size(); i++) {
      if ("+".equals(operator.get(operatorIdx))) {
        result = add(result, number.get(i));
      }
      if ("-".equals(operator.get(operatorIdx))) {
        result = subtract(result, number.get(i));
      }
      if ("/".equals(operator.get(operatorIdx))) {
        result = divide(result, number.get(i));
      }
      if ("*".equals(operator.get(operatorIdx))) {
        result = multiply(result, number.get(i));
      }
      operatorIdx++;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("계산할 값은?");
    String input = sc.nextLine(); // 2 + 3 * 4 / 2
    String[] data = input.split(" ");
    int result = calculate(getNumbers(data), getOperators(data));

    System.out.println("연산결과는 = "+ result);
  }

}
