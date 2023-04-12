package racing.controller.output;

import java.util.stream.IntStream;
import racing.domain.Car;

public class ResultView {

  private final String RESULT_TITLE = "실행 결과";
  private final String EMPTY_LINE = "";
  private final String ONE_LINE = "-";

  public void printEmptyLine() {
    System.out.println(EMPTY_LINE);
  }

  /**
   * 자동차의 위치를 출력합니다.
   * <p>
   * position 이 0인 경우 빈 라인을 출력합니다.
   */
  public void printCarPosition(Car car) {
    int carPosition = car.position();

    if (isZeroPosition(carPosition)) {
      printEmptyLine();
      return;
    }

    printPosition(carPosition);

    printEmptyLine();
  }

  private void printPosition(int carPosition) {
    IntStream.range(0, carPosition)
        .forEach(i -> printOneLine());
  }

  private void printOneLine() {
    System.out.print(ONE_LINE);
  }

  private boolean isZeroPosition(int carPosition) {
    return carPosition == 0;
  }

  public void printResultTitle() {
    System.out.println(RESULT_TITLE);
  }
}
