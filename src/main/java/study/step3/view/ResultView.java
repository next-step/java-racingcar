package study.step3.view;

import study.step3.domain.Cars;
import study.step3.utils.MessageUtil;

public class ResultView {

  public void printPosition(Cars cars, int times) {
    for (int i = 0; i < times; i++) {
      cars.getCars().stream()
          .filter(car -> car.curPosition() > 0)
          .forEach(car -> System.out.println(car.curPath()));

      printNextLine();
    }
  }

  public void printRacingEndMessage() {
    System.out.println(MessageUtil.carRacingEndMessage);
  }

  public void printNextLine() {
    System.out.println();
  }

}
