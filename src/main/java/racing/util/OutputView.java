package racing.util;

import racing.types.CarRacingGameSimulateResult;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showLocation(CarRacingGameSimulateResult result) {
    String output = result.toSimulationLocationString();
    System.out.print(output.substring(0, output.length() - 1));
  }

  public static void showWinner(CarRacingGameSimulateResult result) {
    System.out.print(result.toWinnerNamesString() + " 가 최종 우승했습니다.");
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
