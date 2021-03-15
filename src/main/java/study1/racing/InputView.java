package study1.racing;

import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public void closeScanner() {
    scanner.close();
  }

  public int getParticipants() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int participant = Integer.parseInt(scanner.nextLine());
    return participant;
  }

  public int getRound() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    int round = Integer.parseInt(scanner.nextLine());
    return round;
  }

}
