package study.step3.view;

import study.step3.domain.Cars;
import study.step3.utils.MessageUtil;

public class ResultView {

  public void printPosition(Cars cars) {
    cars.getCars().stream()
        .filter(car -> car.curPosition() > 0)
        .forEach(car -> printPath(car.curPosition()));

    printNextLine();
  }

  public void printRacingEndMessage() {
    System.out.println(MessageUtil.carRacingEndMessage);
  }

  public void printNextLine() {
    System.out.println();
  }

  public void printPath(int cuPosition) {
    StringBuilder path = new StringBuilder();

    for (int i = 0; i < cuPosition; i++) {
      path.append("-");
    }

    System.out.println(path);
  }

}
