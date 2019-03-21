package racing.view;

import java.util.List;
import racing.domain.Car;

public class ConsoleResultView {

  public void printMoveResult(List<Car> cars) {
    cars.forEach(this::printCarPosition);
    System.out.print("\n");
  }

  public void printWinner(String winnerCarNames) {
    System.out.println(winnerCarNames + "가 최종 우승했습니다.");
  }

  private void printCarPosition(Car car) {
    System.out.print(car.getName() + " : ");

    int position = car.getPosition();
    for (int index = 0; index < position; index++) {
      System.out.print("-");
    }
    System.out.print("\n");
  }
}
