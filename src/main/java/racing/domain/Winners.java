package racing.domain;

import java.util.LinkedList;
import java.util.List;

public class Winners {

  private final List<Car> winnerCars = new LinkedList<>();

  public String getWinnersName() {
    StringBuilder winnerNames = new StringBuilder();
    for (Car car : this.winnerCars) {
      winnerNames.append(car.name()).append(", ");
    }
    return winnerNames.delete(winnerNames.length() - 2, winnerNames.length()).toString();
  }

  public List<Car> findWinner(int maxDistance, Cars cars) {
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