package study.racingcar;

import study.racingcar.domain.Race;
import study.racingcar.factory.RaceFactory;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingGame {

  public static void main(String[] args) {
    String[] nameOfCars = InputView.inputNameOfCars();
    int numOfRaces = InputView.inputNumOfRaces();

    Race race = RaceFactory.createRace(nameOfCars);
    for (int i = 0; i < numOfRaces; i++) {
      race.play();
      ResultView.printResult(i, race.getCars());
    }

    ResultView.printWinners(race.getCars());
  }
}
