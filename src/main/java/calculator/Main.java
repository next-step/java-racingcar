package calculator;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Long result = Calculator.run("2 + 3 * 4 / 2");
    System.out.println(result);
  }
}
