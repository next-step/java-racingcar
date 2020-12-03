package step3.view;

import java.util.Scanner;

public class RacingGameView {

  public static int getNumberOfCarFromUser() {
    System.out.print("자동차 대수는 몇 대 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static int getGameCountFromUser() {
    System.out.print("시도할 회수는 몇 회 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

}
