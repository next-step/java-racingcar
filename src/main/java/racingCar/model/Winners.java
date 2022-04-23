package racingCar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {

  private final List<Car> cars;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Winners winners = (Winners) o;
    return Objects.equals(cars, winners.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }

  public Winners(List<Car> cars) {
    this.cars = cars;
  }

  public List<String> findWinnerNameList() {
    List<String> carNames = new ArrayList<>();
    for (Car car : cars) {
      addCarName(carNames, car);
    }
    return carNames;
  }

  private void addCarName(List<String> carNames, Car car) {
    if(car.currentPosition() == findWinnerPosition()) {
      carNames.add(car.carName());
    }
  }

  private int findWinnerPosition() {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = car.changeMaxPosition(maxPosition);
    }
    return maxPosition;
  }


}
