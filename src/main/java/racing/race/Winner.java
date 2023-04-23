package racing.race;

import java.util.LinkedList;
import java.util.List;

public class Winner {

  private final List<Car> winnerCars = new LinkedList<>();

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