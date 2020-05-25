package step5.view;

import step5.domain.Car;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

  private ResultView() {};

  public static void printResultText () {
    System.out.println("실행 결과");
  }

  public static void printRace (Stream<Car> stream) {
    System.out.println(
      stream.map(ResultView::getCarPositionString)
            .collect(Collectors.joining("\n"))
      + "\n"
    );
  }

  public static String getCarPositionString (Car car) {
    return String.join(" : ",
      car.getName(),
      Arrays.stream(new String[car.getPosition()])
            .map(v -> "-")
            .collect(Collectors.joining(""))
    );
  }

  public static void printWinner (Stream<Car> cars) {
    String winners = cars.map(v -> v.getName()).collect(Collectors.joining(", "));
    System.out.printf("%s가 최종 우승 했습니다.\n", winners);
  }

}
