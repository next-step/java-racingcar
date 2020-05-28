package racinggame.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.model.domain.Car;
import racinggame.model.domain.RacingCarFactory;

public class RacingGameImpl implements RacingGame {

  private int time;
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

    this.time--;

    return RacingCarFactory.copyRacingCarList(racingCarList);
  }

  @Override
  public List<Car> getWinnerList() {
    int maxDistance = racingCarList.stream()
        .max(Car::compareTo)
        .get()
        .getDistance();
    List<Car> winnerList = racingCarList.stream()
        .filter(car -> car.getDistance() == maxDistance)
        .collect(Collectors.toList());

    return RacingCarFactory.copyRacingCarList(winnerList);
  }

  @Override
  public boolean isEnd() {
    return this.time == 0;
  }
}