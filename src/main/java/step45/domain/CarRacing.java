package step45.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

  private int numOfMove;
  private final List<Car> carList = new ArrayList<>();

  public CarRacing(final String[] carNames, final int numOfMove) {
    this.numOfMove = numOfMove;
    for (String carName : carNames) {
      carList.add(new Car(carName, new RandomMoveStrategy()));
    }
  }

  public boolean isFinish() {
    return this.numOfMove > 0;
  }

  public void moveAllCars() {
    carList.forEach(Car::move);
    this.numOfMove--;
  }

  public String[] getWinnerList() {
    List<String> winnerList = new ArrayList<>();
    int maxLocation = getMaxLocation();
    for (Car car : carList) {
      addToWinnerList(winnerList, maxLocation, car);
    }
    return winnerList.toArray(new String[winnerList.size()]);
  }

  public List<Car> getCarList() {
    return carList;
  }

  private int getMaxLocation() {
    int maxLocation = 0;
    for (Car car : carList) {
      maxLocation = Math.max(maxLocation, car.getLocation());
    }
    return maxLocation;
  }

  private void addToWinnerList(List<String> winnerList, int maxLocation, Car car) {
    if (car.getLocation() != 0 && maxLocation == car.getLocation()) {
      winnerList.add(car.getName());
    }
  }
}
