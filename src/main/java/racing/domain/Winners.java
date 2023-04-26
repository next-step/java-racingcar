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

  public void addWinner(Car car) {
    winnerCars.add(car);
  }

  public List<Car> getWinnerCars() {
    return winnerCars;
  }

}