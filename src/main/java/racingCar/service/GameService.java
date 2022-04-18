package racingCar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.model.Track;
import racingCar.model.Winner;
import racingCar.strategy.CarMoveRandomStrategy;
import racingCar.util.WinnerUtils;
import racingCar.view.InputTable;

public class GameService {

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
      addRacingHistory(rounds, printCars, car);
    }
    return printCars;
  }

  private void addRacingHistory(Integer rounds, List<RacingCarHistory> printCars, Car car) {
    for (int i = 0; i < rounds; i++) {
      car = car.move(new CarMoveRandomStrategy());
      printCars.add(new RacingCarHistory(i + 1, car));
    }
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

  public String addWinner(List<Car> otherGameParticipants) {
    return coWinner(winnerCalculator(otherGameParticipants), otherGameParticipants);
  }

  public Winner winnerCalculator(List<Car> gameParticipants) {
    Winner winner = WinnerUtils.getChallenger(gameParticipants.get(0));
    for (Car participant : gameParticipants) {
      winner = findWinner(winner, participant);
    }
    return winner;
  }

  public String coWinner(Winner winner, List<Car> otherGameParticipants) {
    for (Car otherGameParticipant : otherGameParticipants) {
      winner = getCoWinner(winner, WinnerUtils.getChallenger(otherGameParticipant));
    }
    return winner.toString();
  }

  private Winner findWinner(Winner winner, Car challenger) {
    if (winner.match(challenger)) {
      winner = WinnerUtils.getChallenger(challenger);
    }
    return winner;
  }

  private Winner getCoWinner(Winner winner, Winner challenger) {
    if (!winner.equals(challenger) && winner.equalPosition(challenger)) {
      return new Winner(winner.toString().concat(", ").concat(challenger.toString()));
    }
    return winner;
  }

}