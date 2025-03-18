package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;

public class ResultView {

  public static void printResult(List<Car> result) {
    System.out.println("실행 결과");

    String output = result.stream()
        .map(car -> car.getName() + ":" + "-".repeat(car.getPosition())) // 위치만큼 "-" 생성
        .collect(Collectors.joining("\n")); // 각 자동차 결과를 줄바꿈으로 연결

    System.out.println(output);
    System.out.println();
  }

  public static void printWinner(List<String> winners) {
    System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
  }
}
