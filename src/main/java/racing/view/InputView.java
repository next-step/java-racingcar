package racing.view;

import racing.vo.RacingCarGamePlayInfo;

import java.util.Scanner;

public class InputView {
  private final static String FIRST_ASK = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private final static String SECONDARY_ASK = "시도할 회수는 몇 회 인가요?";

  private InputView() {
  }

  public static RacingCarGamePlayInfo executeConsole() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println(FIRST_ASK);
      String playerNames = scanner.nextLine();

      System.out.println(SECONDARY_ASK);
      int roundTotalCount = scanner.nextInt();
      return RacingCarGamePlayInfo.newPlayInfo(playerNames, roundTotalCount);
    }

  }
}
