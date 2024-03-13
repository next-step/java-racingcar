package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;

public class ResultView {
  private static final String PROGRESS_BAR = "-";

  public static void end() {
    System.out.println("===============레이스가 종료되었습니다.===============");
  }

  public static void start(){
    System.out.println("===============레이스 시작!!!===============");
  }

  public static void round(int i) {
    System.out.println(String.format("===============ROUND [%s]===============", i));
  }

  public static void raceProgress(int count) {
    for (int i=0; i<count; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void showWinner(List<Car> cars) {
    System.out.println(String.format("===============최종 우승자 [%s]===============", getWinner(cars)));
  }

  public static String getWinner(List<Car> cars) {
    int maxRunCount = cars.stream()
        .mapToInt(Car::getRunCount)
        .max()
        .orElse(0);

    List<String> winners = cars.stream()
        .filter(car -> car.getRunCount() == maxRunCount)
        .map(Car::getName)
        .collect(Collectors.toList());

    return String.join(", ", winners);
  }
}
