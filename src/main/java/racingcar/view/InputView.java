package racingcar.view;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in); // 단일 Scanner 유지

  public static int inputCarCount() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int carCount = Integer.parseInt(scanner.nextLine().trim());
    return carCount;
  }

  public static int inputRound() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    int round = Integer.parseInt(scanner.nextLine().trim());
    return round;
  }

  public static void closeScanner() {
    scanner.close();
  }
}
