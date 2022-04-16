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

  public Winner winnerCalculator(List<Car> racingGameParticipants) {
    Winner winner = new Winner(racingGameParticipants.get(0));
    for (int i = 1; i < racingGameParticipants.size(); i++) {
      winner = winnerChecker(winner, racingGameParticipants.get(i));
    }
    racingGameParticipants.remove(winner.winnerCar());
    return winner;
  }

  private Winner winnerChecker(Winner winner, Car nextCar) {
    if (winner.winnerCar().position() < nextCar.position()) {
      winner = new Winner(nextCar);
    }
    return winner;
  }

  public String sameScoreChecker(Winner winner, List<Car> otherParticipants) {
    Car winnerCar = winner.winnerCar();
    String coWinnerNames = winnerCar.name();
    for (Car otherParticipant : otherParticipants) {
      coWinnerNames = coWinnerLineUp(winnerCar, coWinnerNames, otherParticipant);
    }
    return coWinnerNames;
  }

  private String coWinnerLineUp(Car winnerCar, String coWinnerNames, Car otherParticipant) {
    if (winnerCar.position() == otherParticipant.position()) {
      coWinnerNames = coWinnerNames.concat(", ").concat(otherParticipant.name());
    }
    return coWinnerNames;
  }

}
