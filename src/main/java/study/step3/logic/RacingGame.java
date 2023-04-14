package study.step3.logic;

import study.step3.domain.Race;
import study.step3.factory.RaceFactory;
import study.step3.view.ResultView;

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
