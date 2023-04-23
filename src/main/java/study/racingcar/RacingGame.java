package study.racingcar;

import study.racingcar.domain.Race;
import study.racingcar.factory.CarFactory;
import study.racingcar.factory.RaceFactory;
import study.racingcar.factory.RandomIntFactory;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingGame {

  private static final RandomIntFactory RANDOM_INT_GENERATOR = new RandomIntFactory();

  public static void main(String[] args) {
    String[] nameOfCars = InputView.inputNameOfCars();
    int numberOfRaces = InputView.inputNumberOfRaces();

    Race race = RaceFactory.createRace(CarFactory.createCars(nameOfCars));
    for (int i = 0; i < numberOfRaces; i++) {
      race.play(RANDOM_INT_GENERATOR);
      ResultView.printResult(i, race.getCars());
    }

    ResultView.printWinners(race.findWinner());
  }
}
