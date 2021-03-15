package study1.racing;

import java.util.Scanner;

public class InputView {

  public static int getParticipants(Scanner scanner) {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int participant = Integer.parseInt(scanner.nextLine());
    return participant;
  }

  public static int getRound(Scanner scanner) {
    System.out.println("시도할 회수는 몇 회 인가요?");
    int round = Integer.parseInt(scanner.nextLine());
    return round;
  }

}
