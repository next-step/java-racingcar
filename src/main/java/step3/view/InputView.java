package step3.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCAN = new Scanner(System.in);

  private InputView() { }

  public static int inputCars () {
    System.out.println("자동차 수는 몇 대 인가요?");;
    return Integer.parseInt(SCAN.nextLine());
  }

  public static int inputTime () {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return Integer.parseInt(SCAN.nextLine());
  }
}
