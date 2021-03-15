package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public int getMaxPosition() {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = comparePosition(car.getPosition(), maxPosition);
    }
    return maxPosition;
  }

  private int comparePosition(Position position, int maxPosition) {
    return Math.max(position.getPosition(), maxPosition);
  }

  private boolean isWinner(Position position, int maxPosition) {
    return position.getPosition() == maxPosition;
  }

  private void addWinner(List<Car> winner, Car car, int maxLocation) {
    if (isWinner(car.getPosition(), maxLocation)) {
      winner.add(car);
    }
  }

  public List<Car> getWinnerList() {
    return getWinnerList(getMaxPosition());
  }

  private List<Car> getWinnerList(int maxPosition) {
    List<Car> winnerCarList = new ArrayList<>();

    cars.forEach(car -> addWinner(winnerCarList, car, maxPosition));
    return winnerCarList;
  }

}
