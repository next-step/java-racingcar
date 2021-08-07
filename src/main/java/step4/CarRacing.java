package step4;

import java.util.ArrayList;

public class CarRacing {

  private final int numOfMove;
  private final ArrayList<Car> carList = new ArrayList<>();

  public CarRacing(final String[] carNames, final int numOfMove) {
    this.numOfMove = numOfMove;
    for (String carName : carNames) {
      carList.add(new Car(carName, new RandomMoveStrategy()));
    }
  }

  public void startRacing() {
    for (int i = 0; i < numOfMove; i++) {
      moveAllCars();
    }
  }

  public ArrayList<String> getWinnerList() {
    ArrayList<String> winnerList = new ArrayList<>();
    int winnerLocation = 0;
    for (Car car : carList) {
      int carLocation = car.getLocation();
      clearWinnerList(winnerList, winnerLocation, carLocation);
      addToWinnerList(winnerList, winnerLocation, carLocation, car.getName());
      winnerLocation = Math.max(winnerLocation, carLocation);
    }
    return winnerList;
  }

  private void moveAllCars() {
    carList.forEach(Car::move);
  }

  private void clearWinnerList(ArrayList<String> winnerList, int winnerLocation, int carLocation) {
    if (winnerLocation < carLocation) {
      winnerList.clear();
    }
  }

  private void addToWinnerList(ArrayList<String> winnerList, int winnerLocation, int carLocation,
      String carName) {
    if (winnerLocation <= carLocation) {
      winnerList.add(carName);
    }
  }
}
