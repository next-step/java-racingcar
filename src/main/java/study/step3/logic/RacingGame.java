package study.step3.logic;

import study.step3.domain.Race;
import study.step3.factory.CarFactory;
import study.step3.factory.RaceFactory;
import study.step3.view.ResultView;

public class RacingGame {

  private int numOfCars;
  private int numOfRaces;

  public RacingGame(int numOfCars, int numOfRaces) {
    this.numOfCars = numOfCars;
    this.numOfRaces = numOfRaces;
  }

  public void start() {
    Race race = RaceFactory.createRace(numOfCars);

    for (int i = 0; i < this.numOfRaces; i++) {
      race.play();
      ResultView.printResult(i, race.getCarList());
    }
  }
}
