package step3;

import java.util.Scanner;

public class InputView {
  public static int getInputNumberOfCars() {
    System.out.println("자동차 대수는 몇 대 인가요?\n");
    return Integer.parseInt((new Scanner(System.in)).nextLine());
  }

  public static int getInputNumberOfReps() {
    System.out.println("시도할 횟수는 몇 회 인가요?\n");
    return Integer.parseInt((new Scanner(System.in)).nextLine());
  }
}
