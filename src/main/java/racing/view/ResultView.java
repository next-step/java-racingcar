package racing.view;

import java.util.List;
import java.util.stream.IntStream;
import racing.domain.Car;

public class ResultView {

  private ResultView() {
  }

  public static void println(String text) {
    System.out.println(text);
  }

  public static void printEmptyLine() {
    System.out.println("");
  }

  public static void printCarPosition(List<Car> cars) {
    for (Car car : cars) {
      printCarPosition(car);
      printEmptyLine();
    }
  }

  private static void printCarPosition(Car car) {
    System.out.print(car.name() + " : ");
    IntStream.range(0, car.position())
        .forEach(i -> printOneLine());
  }

  private static void printOneLine() {
    System.out.print("-");
  }

  public static void printWinners(String[] winners) {
    System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
  }
}
