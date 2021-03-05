package racingcar.io;

import racingcar.Game;

public class Printer {

  private Printer() {}

  private static final String PROMPT = "> ";

  public static void welcomeMessage() {
    System.out.println("신나는 레이싱 게임에 오신것을 환영합니다.");
  }

  public static void printBlankLine() {
    System.out.println(System.lineSeparator());
  }

  public static void printPrompt() {
    System.out.print(PROMPT);
  }

  public static void printGameResult(Game game) {
    System.out.println("실행 결과");
    System.out.println(game.getCarsStatus());
  }
}
