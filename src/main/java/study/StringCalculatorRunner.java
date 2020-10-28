package study;

import java.util.Scanner;

public class StringCalculatorRunner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String expression = scanner.nextLine();

    System.out.println(StringCalculator.compute(expression));
  }
}
