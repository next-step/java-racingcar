package step4.view;

import step4.Car;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

  private ResultView() {};

  public static void printResultText () {
    System.out.println("실행 결과");
  }

  public static void printRace (Stream<Car> stream) {
    System.out.println(
      stream.map(car -> car.getPositionString()).collect(Collectors.joining("\n"))
      + "\n"
    );
  }

  public static void printWinner (String winners) {
    System.out.printf("%s가 최종 우승 했습니다.\n", winners);
  }

}
