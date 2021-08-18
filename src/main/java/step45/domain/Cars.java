package step45.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public void moveCars(MoveStrategy moveStrategy) {
    cars.forEach((car -> car.move(moveStrategy.getMoveDistance())));
  }

  public List<Car> getWinners() {
    int maxLocation = getMaxLocation();
    List<Car> winners = getCarsByLocation(maxLocation);
    return Collections.unmodifiableList(winners);
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  private int getMaxLocation() {
    int maxLocation = 0;
    for (Car car : cars) {
      maxLocation = Math.max(maxLocation, car.getLocation());
    }
    return maxLocation;
  }

  private List<Car> getCarsByLocation(int maxLocation) {
    List<Car> carList = new ArrayList<>();
    cars.forEach(car -> addCarByLocation(carList, car, maxLocation));
    return carList;
  }

  private void addCarByLocation(List<Car> carList, Car car, int location) {
    if (car.getLocation() == location) {
      carList.add(car);
    }
  }
}
