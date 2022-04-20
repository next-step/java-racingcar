package racingCar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racingCar.model.Car;
import racingCar.model.RacingCarHistory;
import racingCar.model.Track;
import racingCar.model.Winners;
import racingCar.strategy.CarMoveRandomStrategy;
import racingCar.util.StringUtils;
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

  public String findWinners(List<Car> cars) {
    Winners winners = new Winners();
    List<String> coWinnerNameList = winners.findCoWinnerNameList(cars,
        winners.findWinnerPosition(cars));
    coWinnerNameList.removeAll(Collections.singletonList(null));

    return StringUtils.join(coWinnerNameList);
  }


}