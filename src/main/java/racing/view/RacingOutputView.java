package racing.view;

import java.util.List;
import racing.dto.RacingOutput;

public class RacingOutputView {

  public static final String DISTANCE = "-";
  public static final String EMPTY = "";

  private List<RacingOutput> racingOutputs;

  public RacingOutputView(List<RacingOutput> racingOutputs) {
    this.racingOutputs = racingOutputs;
  }

  public void printCarDistance() {
    for (RacingOutput racingOutput : racingOutputs) {
      printRacingOutput(racingOutput);
    }
    System.out.println(EMPTY);
  }

  private void printRacingOutput(RacingOutput racingOutput) {
    for (int distance : racingOutput.getDistances()) {
      System.out.print(DISTANCE);
    }
    System.out.println(EMPTY);
  }

  public void printResultTitle() {
    System.out.println("실행 결과");
  }
}
