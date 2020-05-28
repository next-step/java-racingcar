package racinggame.model.service;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.model.domain.Car;
import racinggame.model.domain.CarDTO;
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
  public List<CarDTO> play() {
    for (Car racingCar : racingCarList) {
      racingCar.move();
    }

    this.time--;

    return RacingCarFactory.createRacingCarDTOList(racingCarList);
  }

  @Override
  public List<CarDTO> getWinnerList() {
    int maxDistance = racingCarList.stream()
        .max(Car::compareTo)
        .get()
        .getDistance();
    List<Car> winnerList = racingCarList.stream()
        .filter(car -> car.getDistance() == maxDistance)
        .collect(Collectors.toList());

    return RacingCarFactory.createRacingCarDTOList(winnerList);
  }

  @Override
  public boolean isNotEnd() {
    return 0 < this.time;
  }
}