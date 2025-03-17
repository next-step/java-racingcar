package step4.carracing;

public class ResultView {
  private static final String CAR_POSITION_SYMBOL = "-";

  public static void printCarStatus(Car car) {
    String carPositionView = CAR_POSITION_SYMBOL.repeat(car.getPosition());
    System.out.println(car.getName() + " : " + carPositionView);
  }
}
