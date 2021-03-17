package racing.view;

import racing.vo.RacingCarGamePlayInfo;

import java.util.Scanner;

public class InputView {

  private InputView() {
  }

  public static RacingCarGamePlayInfo executeConsole() {
    int totalPlayer;
    int totalRound;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("자동차 대수는 몇 대 인가요?");
      totalPlayer = scanner.nextInt();
      System.out.println("시도할 회수는 몇 회 인가요?");
      totalRound = scanner.nextInt();
    }

    return RacingCarGamePlayInfo.newPlayInfo(totalPlayer, totalRound);
  }

}
