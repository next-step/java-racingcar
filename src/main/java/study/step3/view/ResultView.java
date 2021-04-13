package study.step3.view;


import java.util.List;
import study.step3.domain.Car;
import study.step3.utils.MessageUtil;

public class ResultView {

  public void printPosition(List<Car> cars) {
    cars.stream().filter(car -> car.curPosition() > 0)
        .forEach(car -> System.out.println(car.curPath()));

    printNextLine();
  }

  public void printRacingEndMessage() {
    System.out.println(MessageUtil.carRacingEndMessage);
  }

  public void printNextLine() {
    System.out.println();
  }

}
