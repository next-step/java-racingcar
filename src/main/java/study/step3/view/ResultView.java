package study.step3.view;

import study.step3.domain.Cars;
import study.step3.utils.MessageUtil;

public class ResultView {

  public void printPosition(Cars cars) {
    cars.getCars().stream()
        .filter(car -> car.curPosition() > 0)
        .forEach(car -> printPath(car.name(), car.curPosition()));

    printNextLine();
  }

  public void printRacingEndMessage() {
    System.out.println(MessageUtil.carRacingEndMessage);
  }

  public void printNextLine() {
    System.out.println();
  }

  public void printPath(String name, int cuPosition) {
    StringBuilder path = new StringBuilder();

    for (int i = 0; i < cuPosition; i++) {
      path.append("-");
    }

    System.out.println(name + " : " + path);
  }

  public void printWinners(String winners) {
    if (!"".equals(winners)) {
      System.out.println(winners + "가 최종 우승했습니다.");
    }
  }

}
