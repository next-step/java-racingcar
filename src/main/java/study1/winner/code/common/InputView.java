package study1.winner.code.common;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {}

  public static String getParticipants() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    String participant = scanner.nextLine();
    return participant;
  }

  public static int getRound() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    int round = Integer.parseInt(scanner.nextLine());
    return round;
  }

  public static void close() {
    scanner.close();
  }
}
