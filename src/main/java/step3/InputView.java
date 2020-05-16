package step3;

import java.util.Scanner;

public class InputView {

  private InputView () {}

  public static int[] inputCars () {
    Scanner scan = new Scanner(System.in);
    System.out.println("자동차 대수는 몇 대 인가요?");
    int size = Integer.parseInt(scan.nextLine());
    int[] carPositions = new int[size];
    for (int i = 0; i < size; i++) carPositions[i] = 0;
    return carPositions;
  }

  public static int inputTime () {
    Scanner scan = new Scanner(System.in);
    System.out.println("시도할 회수는 몇 회 인가요?");
    return Integer.parseInt(scan.nextLine());
  }

}
