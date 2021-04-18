package step3.view;

import java.util.List;
import step3.data.Car;

public class ResultView {

  public void printHeader() {
    System.out.println();
    System.out.println("실행 결과");
  }

  public void printLapResult(List<Car> carList) {
    for(Car car : carList) {
      printPosition(car.position);
    }
    System.out.println();
  }

  public void printPosition(int position) {
    for (int i = 0; i < position; i++) {
      System.out.print("-");
    }
    System.out.println();
  }
}
