package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.Car;

public class ResultView {

  public void printMoveResult(List<Car> cars) {
    cars.forEach(this::printCarPosition);
    System.out.print("\n");
  }

  public void printWinner(List<Car> winnerCars) {

    String winnerCarNames = winnerCars.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.println(winnerCarNames + "가 최종 우승했습니다.");
  }

  private void printCarPosition(Car car) {

    System.out.print(car.getName() + " : ");

    int position = car.getPosition();
    for(int index = 0; index < position; index++) {
      System.out.print("-");
    }
    System.out.print("\n");
  }
}
