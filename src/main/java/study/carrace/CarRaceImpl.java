package study.carrace;

import study.car.Car;
import study.dto.InputDto;
import study.util.Input;
import study.util.Randomizer;
import study.util.Result;
import study.view.InputView;
import study.view.OutputView;

public class CarRaceImpl implements CarRace {
  private final Randomizer randomizer;

  public CarRaceImpl(Randomizer randomizer) {
    this.randomizer = randomizer;
  }

  @Override
  public void run(InputView inputView, OutputView outputView) {
    InputDto inputDto = inputView.view();

    Car[] cars = Car.createCarsAsStr(inputDto.getCarsStr());
    RaceGame raceGame = new RaceGameImpl(cars, inputDto.getTryCount(), randomizer);
    Race[] races = raceGame.process();

    outputView.view(races, inputDto.getTryCount());
  }
}
