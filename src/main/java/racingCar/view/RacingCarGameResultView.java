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
    System.out.println(allSnapShot);
  }

  public void printWinners(List<RacingCar> winners) {
    final String joinedWinners = winners.stream()
            .map(RacingCar::getCarName)
            .collect(Collectors.joining(", "));
    System.out.printf("%s가 최종 우승했습니다.\n", joinedWinners);
  }

  private String getVisualRacingCarDistance(RacingCar racingCar) {
    int racingCarPosition = racingCar.getPosition();
    StringBuilder sb = new StringBuilder();
    sb.append(racingCar.getCarName());
    sb.append(" : ");

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