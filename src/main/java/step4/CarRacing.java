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
    ArrayList<String> winnerList = new ArrayList<>();
    int winnerLocation = 0;
    for (Car car : carList) {
      int carLocation = car.getLocation();
      clearWinnerList(winnerList, winnerLocation, carLocation);
      addToWinnerList(winnerList, winnerLocation, carLocation, car.getName());
      winnerLocation = Math.max(winnerLocation, carLocation);
    }
    return winnerList.toArray(new String[winnerList.size()]);
  }

  private void clearWinnerList(ArrayList<String> winnerList, int winnerLocation, int carLocation) {
    if (carLocation > 0 && carLocation > winnerLocation) {
      winnerList.clear();
    }
  }

  private void addToWinnerList(ArrayList<String> winnerList, int winnerLocation, int carLocation,
      String carName) {
    if (carLocation > 0 && carLocation >= winnerLocation) {
      winnerList.add(carName);
    }
  }
}
