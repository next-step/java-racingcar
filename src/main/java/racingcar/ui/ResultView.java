package racingcar.ui;

import java.util.Iterator;
import racingcar.application.Car;
import racingcar.application.Cars;
import racingcar.dto.CarNames;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행 결과";
  private static final String HYPHEN = "-";

  public void printResultAlert() {
    Printer.println(RESULT_MESSAGE);
  }

  public void printLocations(Cars cars) {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars.toList()) {
      sb.append(car.carName().name())
          .append(" : ")
          .append(HYPHEN.repeat(car.location()))
          .append("\n");
    }

    Printer.println(sb.toString());
  }

  public void printWinner(CarNames winnerNames) {
    Printer.println(winnerNames + "가 최종 우승했습니다.");
  }
}
