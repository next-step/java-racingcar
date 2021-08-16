package step45;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

  private final int numOfMove;
  private final List<Car> carList = new ArrayList<>();

  public CarRacing(final String[] carNames, final int numOfMove) {
    this.numOfMove = numOfMove;
    for (String carName : carNames) {
      carList.add(new Car(carName, new RandomMoveStrategy()));
    }
  }

  public void startRacing() {
    ResultView.printResultTitle();
    for (int i = 0; i < numOfMove; i++) {
      moveAllCars();
      ResultView.printCurrentRoundResult(carList);
      ResultView.printRoundDivider();
    }
    ResultView.printWinnerList(getWinnerList());
  }

  private void moveAllCars() {
    carList.forEach(Car::move);
  }

  private String[] getWinnerList() {
    List<String> winnerList = new ArrayList<>();
    int maxLocation = getMaxLocation();
    for (Car car : carList) {
      addToWinnerList(winnerList, maxLocation, car);
    }
    return winnerList.toArray(new String[winnerList.size()]);
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
