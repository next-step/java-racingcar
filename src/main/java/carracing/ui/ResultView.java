package carracing.ui;

import carracing.domain.Car;

import java.util.List;

public class ResultView {

  public void printStatus(List<Car> carList) {
    StringBuilder sb = new StringBuilder();
    for(Car car : carList) {
      sb.append(printCarStatus(car))
        .append(System.lineSeparator());
    }
    System.out.println(sb);
  }

  private String printCarStatus(Car car) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < car.getNowStep(); i++) {
      sb.append("-");
    }
    return sb.toString();
  }

}
