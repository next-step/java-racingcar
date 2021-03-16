package racing.view;

import racing.domain.RacingRound;

import java.util.Collection;
import java.util.List;

public class ResultView {

  private ResultView() {
  }

  public static void print(List<RacingRound> racingRounds) {
    racingRounds.stream()
            .peek(round -> System.out.println("\nround start"))
            .map(RacingRound::getRacingCars)
            .flatMap(Collection::stream)
            .forEach(racingCar -> System.out.println(String.format("%s : %s", racingCar.getName(), racingCar.getPosition())));
  }
}
