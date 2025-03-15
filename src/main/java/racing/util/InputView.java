package racing.util;

import java.util.Scanner;

public class InputView {

  public static int showCarCountInput() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static int showSimulateCountInput() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}
