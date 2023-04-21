package racingCar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.car.RacingCar;
import racingCar.domain.game.RacingCarGameResult;

public final class RacingCarGameResultView {

  public void printGameResult(RacingCarGameResult gameResult) {
    printAllSnapShot(gameResult.getSnapShots());
    printWinners(gameResult.getWinners());
  }

  public void printAllSnapShot(List<String> snapShots) {
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
}