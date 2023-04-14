package study.racingcar.logic;

import study.racingcar.domain.Race;
import study.racingcar.factory.RaceFactory;
import study.racingcar.view.ResultView;

public class RacingGame {

  private int numOfRaces;
  private String[] nameOfCars;

  public RacingGame(String[] nameOfCars, int numOfRaces) {
    this.nameOfCars = nameOfCars;
    this.numOfRaces = numOfRaces;
  }

  public void start() {
    Race race = RaceFactory.createRace(nameOfCars);

    for (int i = 0; i < this.numOfRaces; i++) {
      race.play();
      ResultView.printResult(i, race.getCars());
    }

    ResultView.printWinners(race.getCars());
  }
}
