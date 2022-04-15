package racingCar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.model.Track;
import racingCar.model.Winner;
import racingCar.strategy.CarMoveRandomStrategy;
import racingCar.view.InputTable;

public class CarService {

  private final static Track TRACK = new Track();

  public List<Car> readyCars() {
    TRACK.addCar(InputTable.insertCarNames());
    return TRACK.getCars();
  }

  public Integer gameRound() {
    return InputTable.howManyGame();
  }

  public List<RacingCarHistory> play(List<Car> allCars, Integer rounds) {
    List<RacingCarHistory> printCars = new ArrayList<>();
    for (Car car : allCars) {
      for (int i = 0; i < rounds; i++) {
        car = car.move(new CarMoveRandomStrategy());
        printCars.add(new RacingCarHistory(i + 1, car, car.index()));
      }
    }
    return printCars;
  }

  public List<Car> gameResult(List<RacingCarHistory> racingHistories,
      Integer rounds) {
    List<Car> resultList = new ArrayList<>();
    for (RacingCarHistory racingHistory : racingHistories) {
      if (Objects.equals(racingHistory.round(), rounds)) {
        resultList.add(racingHistory.car());
      }
    }
    return resultList;
  }

  public Winner winner(List<Car> gameResult) {
    Winner winner = new Winner(gameResult.get(0));
    for (int i = 1; i < gameResult.size(); i++) {
      winner = winnerCalculator(winner, gameResult.get(i));
    }
    gameResult.remove(winner.winnerCar());
    return winner;
  }

  private Winner winnerCalculator(Winner winner, Car nextCar) {
    if (winner.winnerCar().position() < nextCar.position()) {
      winner = new Winner(nextCar);
    }
    return winner;
  }

  public String coWinner(Winner winner, List<Car> gameResult) {
    Car winnerCar = winner.winnerCar();
    String coWinner = winnerCar.name();
    for (Car car : gameResult) {
      coWinner = winnerCalculator(winnerCar, coWinner, car);
    }
    return coWinner;
  }

  private String winnerCalculator(Car winnerCar, String coWinner, Car car) {
    if(winnerCar.position() == car.position()) {
      coWinner = coWinner.concat(", ").concat(car.name());
    }
    return coWinner;
  }

}
