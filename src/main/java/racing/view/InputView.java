package racing.view;

import racing.utils.StringUtils;
import racing.vo.RacingCarGamePlayInfo;

import java.util.Scanner;

public class InputView {
  public final static String FIRST_ASK = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  public final static String SECONDARY_ASK = "시도할 회수는 몇 회 인가요?";
  public final static String PLAYER_NAME_SEPARATOR = ",";

  private InputView() {
  }

  public static RacingCarGamePlayInfo executeConsole() {
    String playerNames;
    int totalRound;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println(FIRST_ASK);
      playerNames = scanner.nextLine();

      System.out.println(SECONDARY_ASK);
      totalRound = scanner.nextInt();
    }

    StringUtils.toList(playerNames, PLAYER_NAME_SEPARATOR);
    return RacingCarGamePlayInfo.newPlayInfo(playerNames, totalRound);
  }

}
