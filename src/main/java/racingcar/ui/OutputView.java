package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

  private final StringBuilder writer;

  public OutputView(StringBuilder writer) {
    this.writer = writer;
  }

  public void printCarPosition(Cars cars, int currentRound) {
    writer.append(currentRound).append("회 라운드 결과입니다.\n");
    for(Car car : cars.getCars()) {
      writer.append(positionToLine(car.getPosition())).append("\n");
    }
    System.out.println(writer.toString());
    clearBuffer();
  }

  public void printInitialCarPosition(Cars cars) {
    writer.append("초기 자동차 위치 결과입니다.\n");
    for(Car car : cars.getCars()) {
      writer.append(positionToLine(car.getPosition())).append("\n");
    }
    System.out.println(writer.toString());
    clearBuffer();
  }

  private String positionToLine(int position) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i <= position; i++){
      sb.append('-');
    }
    return sb.toString();
  }

  private void clearBuffer() {
    writer.setLength(0);
  }

  public void endGame() {
    System.out.println("게임이 종료 되었습니다.");
  }
}
