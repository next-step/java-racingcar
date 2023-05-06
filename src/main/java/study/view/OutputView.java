package study.view;

import study.carrace.Race;
import study.carrace.RaceList;
import study.util.Result;

public class OutputView {
  private final Result result;

  public OutputView(Result result) {
    this.result = result;
  }

  public void view(RaceList raceList, int tryCount) {
    StringBuffer sb = new StringBuffer();

    sb.append("\n").append("실행 결과").append("\n");

    for (int i = 1; i <= tryCount; i++) {
      for (Race race : raceList.getRaces()) {
        sb.append(race.currentRace(i)).append("\n");
      }
      sb.append("\n");
    }

    sb.append(raceList.winner()).append("가 최종 우승했습니다.");

    String output = sb.toString();

    result.print(output);
  }
}
