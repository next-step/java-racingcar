package study.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

  List<Car> cars = new ArrayList<>();

  public void addAll(Car... cars) {
    this.cars.addAll(Arrays.asList(cars));
  }

  public int getSize() {
    return cars.size();
  }

  public void moveByStrategy(MoveStrategy strategy) {
    for (Car car : cars) {
      car.move(strategy);
    }
  }

  public void printPosition() {
    for (Car car : cars) {
      ResultView.printPosition(car.getName(), car.getPosition());
    }
  }

  public List<String> getWinnerNames() {
    int winnerPosition = getWinnerPosition();
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      checkWinner(winnerPosition, winners, car);
    }
    return winners;
  }

  public int getWinnerPosition() {
    int max = 0;
    for (Car car : cars) {
      max = comparePosition(max, car.getPosition());
    }
    return max;
  }

  private int comparePosition(int max, int position) {
    if (max < position) {
      return position;
    }
    return max;
  }

  private void checkWinner(int winnerPosition, List<String> winners, Car car) {
    if (car.getPosition() == winnerPosition) {
      winners.add(car.getName());
    }
  }
}
