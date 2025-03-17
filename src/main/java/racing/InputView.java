package racing;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int getNumberOfCars() {
    System.out.print("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  public static int getNumberOfRounds() {
    System.out.print("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
