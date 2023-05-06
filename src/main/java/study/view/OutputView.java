package study.view;

import study.carrace.Race;
import study.util.Result;

public class OutputView {
  private final Result result;

  public OutputView(Result result) {
    this.result = result;
  }

  public void view(Race[] races, int tryCount) {
    StringBuffer sb = new StringBuffer();

    sb.append("\n").append("실행 결과").append("\n");

    for (int i = 1; i <= tryCount; i++) {
      for (Race race : races) {
        sb.append(race.currentRace(i)).append("\n");
      }
      sb.append("\n");
    }

    sb.append(winner(races)).append("가 최종 우승했습니다.");

    String output = sb.toString();

    result.print(output);
  }


  private String winner(Race[] races) {
    String winners = "";
    int max = 0;

    for(Race race : races) {
      if(max < race.total()) {
        max = race.total();
        winners = race.carName();
      }else if(max == race.total()) {
        winners += ", " + race.carName();
      }
    }

    return winners;
  }
}
