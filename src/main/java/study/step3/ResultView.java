package study.step3;


public class ResultView {

  public void printPosition(Car car) {
      System.out.println(car.curPath());
  }

  public void printRacingEndMessage() {
    System.out.println(MessageUtil.carRacingEndMessage);
  }

}
