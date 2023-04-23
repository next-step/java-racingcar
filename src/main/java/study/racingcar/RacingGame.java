package study.racingcar;

import study.racingcar.domain.Race;
import study.racingcar.factory.CarFactory;
import study.racingcar.factory.RaceFactory;
import study.racingcar.factory.RandomIntFactory;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingGame {

  public static void main(String[] args) {
    String[] nameOfCars = InputView.inputNameOfCars();
    int numberOfRaces = InputView.inputNumberOfRaces();

    Race race = RaceFactory.createRace(CarFactory.createCars(nameOfCars));
    RandomIntFactory randomIntFactory = new RandomIntFactory();
    for (int i = 0; i < numberOfRaces; i++) {
      race.play(randomIntFactory);
      ResultView.printResult(i, race.getCars());
    }

    ResultView.printWinners(race.findWinner());
  }
}
