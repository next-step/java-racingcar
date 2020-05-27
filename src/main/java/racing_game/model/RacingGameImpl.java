package racing_game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameImpl implements RacingGame {
  private int time;
  private final List<Car> racingCarList;

  /**
   * 횟수와 racingCarList 초기화
   * 
   * @param carNameArr : String[], 각 이름에 해당되는 Car객체의 List 생성
   * @param time : int, 횟수
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

    return new ArrayList<Car>(racingCarList);
  }

  @Override
  public List<Car> getWinnerList() {
    List<Car> winnerList = racingCarList.stream().filter(car -> {
      return car.getDistance() == racingCarList.stream().max((car1, car2) -> car1.compareTo(car2))
          .get().getDistance();
    }).collect(Collectors.toList());

    for (Car winner : winnerList) {
      winner = new Car(winner);
    }

    return winnerList;
  }

  @Override
  public int getTime() {
    return this.time;
  }
}


