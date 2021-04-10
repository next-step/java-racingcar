package study.step3;


import java.util.List;

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
