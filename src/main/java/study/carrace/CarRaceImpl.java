package study.carrace;

import study.input.Input;
import study.race.Race;
import study.race.RaceGame;
import study.race.RaceGameImpl;

public class CarRaceImpl implements CarRace {

  private final Input input;

  public CarRaceImpl(Input input) {
    this.input = input;
  }

  @Override
  public String run() {
    int numberOfCars = input.getInput("자동차 대수는 몇 대 인가요?");
    int tryCount = input.getInput("시도할 회수는 몇 회 인가요?");

    RaceGame raceGame = new RaceGameImpl(numberOfCars, tryCount);
    Race[] races = raceGame.process();

    StringBuffer sb = new StringBuffer();

    sb.append("\n").append("실행 결과").append("\n");

    for (int i = 1; i <= tryCount; i++) {
      for (Race race : races) {
        sb.append(race.currentRace(i)).append("\n");
      }
      sb.append("\n");
    }

    return sb.toString();
  }

}
