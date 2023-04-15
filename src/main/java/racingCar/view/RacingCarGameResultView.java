package racingCar.view;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.car.RacingCar;

public final class RacingCarGameResultView {

  private final List<String> snapShots;

  public RacingCarGameResultView () {
    snapShots = new LinkedList<>();
  }

  public void printAllSnapShot() {
    final String allSnapShot = String.join("\n\n", snapShots);
    System.out.println("\n실행 결과");
    System.out.print(allSnapShot);
  }

  private String getVisualRacingCarDistance(RacingCar racingCar) {
    int racingCarPosition = racingCar.getPosition();
    StringBuilder sb = new StringBuilder();
    for (long i = 0; i < racingCarPosition; i++) {
      sb.append('-');
    }
    return sb.toString();
  }

  public void storeSnapShotOfMoveCnt(List<RacingCar> racingCarList) {
    final String snapShot = racingCarList.stream()
        .map(this::getVisualRacingCarDistance)
        .collect(Collectors.joining("\n"));

    snapShots.add(snapShot);
  }
}