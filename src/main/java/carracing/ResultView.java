package carracing;

public class ResultView {
  private static final String CAR_POSITION_SYMBOL = "-";

  public static void printCarStatus(Car car) {
    String carPosition = CAR_POSITION_SYMBOL.repeat(car.getPosition());
    System.out.println(carPosition);
  }
}
