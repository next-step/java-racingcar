package step4.carracing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
  public static void printCarStatus(Car car) {
    System.out.println(car.getStatus());
  }

  public static void printWinners(List<Car> winners) {
    String winnersResult = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.println(winnersResult + "가 최종 우승했습니다.");
  }
}
