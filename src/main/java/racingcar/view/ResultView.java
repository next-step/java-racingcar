package racingcar.view;

import racingcar.model.Car;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * 화면에 Racing 관련 정보들을 출력하는 클래스
 */
public class ResultView {

  private static final String CURRENT_POSITION_MARKER = "-";

  /**
   * 현재 라운드를 화면에 출력
   * @param round
   */
  public static void printCurrentRound(int round) {
    System.out.println(round + "번째 라운드");
  }

  /**
   * 현재 라운드와 다음 라운드 사이에 공백을 추가하여 가독성 up
   */
  public static void addLineBreak() {
    System.out.println();
    System.out.println();
  }

  /**
   * Car의 현재 position을 MARKER을 사용하여 표시
   * ex) ----
   * @param car
   */
  public static void printCurrentPositionOf(Car car) {
    String currentPosition = IntStream.rangeClosed(car.getInitialPosition(), car.getPosition())
            .mapToObj(pos -> CURRENT_POSITION_MARKER)
            .collect(joining());

    System.out.println(currentPosition);
  }
}
