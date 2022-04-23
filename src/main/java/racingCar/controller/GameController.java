package racingCar.controller;

import java.util.List;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.model.Winners;
import racingCar.service.GameService;
import racingCar.view.InputTable;
import racingCar.view.OutputTable;

public class GameController {

  private final GameService gameService;


  public GameController(GameService gameService) {
    this.gameService = gameService;
  }


  public void run() {
    OutputTable.inputCarNames();
    List<Car> cars = readyCar(InputTable.insertCarNames());

    OutputTable.inputGameRounds();
    Integer rounds = gameRound(InputTable.howManyGame());

    List<RacingCarHistory> racingCarHistories = racingHistories(cars, rounds);
    OutputTable.outputGameResult(cars, racingCarHistories);

    List<Car> result = getGameResult(racingCarHistories, rounds);

    OutputTable.findAllWinners(OutputTable.printWinners(winners(result)));

  }

  public List<Car> readyCar(String inputCarNames) {
    return gameService.readyCars(inputCarNames);
  }

  public Integer gameRound(Integer gameRounds) {
    return gameService.gameRound(gameRounds);
  }

  public List<RacingCarHistory> racingHistories(List<Car> cars, int rounds) {
    return gameService.play(cars, rounds);
  }

  public List<Car> getGameResult(List<RacingCarHistory> racingHistories, int rounds) {
    return gameService.gameResult(racingHistories, rounds);
  }

  public List<String> winners(List<Car> allCars) {
    return gameService.findWinnerNames(allCars);
  }

}
