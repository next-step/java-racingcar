package racingcar.view;

import java.util.Scanner;

public class InputView {

  public static int inputCarCount() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("자동차 대수는 몇 대 인가요?");
    int carCount = Integer.parseInt(scanner.nextLine().trim());
    scanner.close();
    return carCount;
  }

  public static int inputRound() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("시도할 회수는 몇 회 인가요?");
    int round = Integer.parseInt(scanner.nextLine().trim());
    scanner.close();
    return round;
  }
}
