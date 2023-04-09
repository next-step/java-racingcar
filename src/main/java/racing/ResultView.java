package racing;

import java.util.stream.IntStream;

public class ResultView {

  public void printEmptyLine() {
    System.out.println("");
  }

  /**
   * 자동차의 위치를 출력합니다.
   *
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
    System.out.print("-");
  }

  private boolean isZeroPosition(int carPosition) {
    return carPosition == 0;
  }

  public void printResultTitle() {
    System.out.println("실행 결과");
  }
}
