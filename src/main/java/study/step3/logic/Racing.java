package study.step3.logic;

import study.step3.domain.Race;
import study.step3.factory.CarFactory;
import study.step3.view.ResultView;

public class Racing {

  private int numOfCars;
  private int numOfRaces;

  public Racing(int numOfCars, int numOfRaces) {
    this.numOfCars = numOfCars;
    this.numOfRaces = numOfRaces;
  }

  public void start() {
    Race race = createRace();

    for (int i = 0; i < this.numOfRaces; i++) {
      race.play();
      ResultView.printResult(i, race.getCarList());
    }
  }

  private Race createRace() {
    return new Race(createCarFactory().createCars(this.numOfCars));
  }

  private CarFactory createCarFactory() {
    return new CarFactory();
  }
}
