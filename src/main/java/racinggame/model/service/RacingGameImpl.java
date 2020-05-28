package racinggame.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.model.domain.Car;
import racinggame.model.domain.RacingCarFactory;

public class RacingGameImpl implements RacingGame {

  private final int time;
  private final List<Car> racingCarList;

  /**
   * 횟수와 racingCarList 초기화
   *
   * @param carNameArr : String[], 각 이름에 해당되는 Car객체의 List 생성
   * @param time       : int, 횟수
   */
  public RacingGameImpl(String[] carNameArr, int time) {
    this.racingCarList = RacingCarFactory.createRacingCarList(carNameArr);
    this.time = time;
  }

  @Override
  public List<Car> play() {
    for (Car racingCar : racingCarList) {
      racingCar.move();
    }

    return new ArrayList<>(racingCarList);
  }

  @Override
  public List<Car> getWinnerList() {
    List<Car> winnerList = racingCarList.stream()
        .filter(car -> car.getDistance() == racingCarList.stream().max(
            Car::compareTo)
            .get().getDistance()).collect(Collectors.toList());

    for (int i = 0, endpoint = winnerList.size(); i < endpoint; i++) {
      winnerList.set(i, new Car(winnerList.get(i)));
    }

    return winnerList;
  }

  @Override
  public int getTime() {
    return this.time;
  }
}


