package racing.race;

import java.util.LinkedList;
import java.util.List;

public class Winners {

  private final List<Car> winnerCars = new LinkedList<>();

  /**
   * 우승한 자동차의 이름들을 , 로 이어붙이는 함수
   * @param cars
   * @return car1, car2, ..., car5
   */
  public String getWinnersName(List<Car> cars) {
    StringBuilder winnerNames = new StringBuilder();
    for (Car car : cars) {
      winnerNames.append(car.name()).append(", ");
    }
    return winnerNames.delete(winnerNames.length() - 2, winnerNames.length()).toString();
  }

  List<Car> findWinner(int maxDistance, Cars cars) {
    for (Car car : cars.getGameCars()) {
      checkWinner(maxDistance, car);
    }
    return winnerCars;
  }

  private void checkWinner(int maxDistance, Car car) {
    if (car.isWinner(maxDistance)) {
      winnerCars.add(car);
    }
  }

}