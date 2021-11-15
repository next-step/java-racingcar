package carracing.domain.entity;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Winner {

  private static final int FIRST_INDEX = 0;

  private final List<Car> winnerList;

  public Winner(List<Car> winnerList) {
    this.winnerList = winnerList;
  }

  public List<Car> getWinnerList() {
    return winnerList;
  }

  public static Winner pickWinner(List<Car> carList) {
    Collections.sort(carList);
    return new Winner(findWinner(carList));
  }

  private static List<Car> findWinner(List<Car> carList) {
    Car firstCar = carList.get(FIRST_INDEX);
    return carList.stream()
                  .filter(car -> car.getNowStep() == firstCar.getNowStep())
                  .collect(toList());
  }
}
