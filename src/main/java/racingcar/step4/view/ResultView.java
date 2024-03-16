package racingcar.step4.view;

import racingcar.step4.domain.RacingCarGame;
import racingcar.step4.domain.Winners;

import java.util.List;

public class ResultView {

  private static final String MOVE_MARK = "-";

  public ResultView() {}

  public void printResult(List<RacingCarGame> racingCarGames) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append("실행 결과").append("\n");

    racingCarGames.forEach(it -> {
      sb.append("[ROUND ").append(it.getRound()).append("]").append("\n");
      printRaceRecords(sb, it);
    });

    System.out.print(sb);
  }

  public void printFinalWinners(List<RacingCarGame> racingCarGames) {
    StringBuilder sb = new StringBuilder();

    Winners winners = RacingCarGame.findFinalGame(racingCarGames).getWinners();
    winners.getWinnerNames().forEach(name -> sb.append(name).append(", "));
    sb.deleteCharAt(sb.length() - 2);
    sb.append("가 최종 우승했습니다.");

    System.out.println(sb);
  }

  private void printRaceRecords(StringBuilder sb, RacingCarGame game) {
    game.getCars().forEach(car ->
        sb.append(printRaceRecord(car.getCarName().get(), car.getPosition().get())).append("\n")
    );
    sb.append("\n");
  }

  private String printRaceRecord(String carName, int moveCount) {
    String result = MOVE_MARK.repeat(Math.max(0, moveCount));
    return carName + " : " + result;
  }
}
