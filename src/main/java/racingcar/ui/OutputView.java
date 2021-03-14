package racingcar.ui;

import racingcar.domain.Cars;

public class OutputView {

  private final StringBuilder writer = new StringBuilder();

  public void printCarPosition(Cars cars, int currentRound) {
    writer.append(currentRound).append("회 라운드 결과입니다.\n");
    writer.append(cars.currentCarsPosition());
    System.out.println(writer.toString());
    clearBuffer();
  }

  public void printInitialCarPosition(Cars cars) {
    writer.append("초기 자동차 위치 결과입니다.\n");
    writer.append(cars.currentCarsPosition());
    System.out.println(writer.toString());
    clearBuffer();
  }


  private void clearBuffer() {
    writer.setLength(0);
  }

  public void endGame(Cars cars) {
    writer.append("우승자는 ").append(cars.getWinner()).append(" 입니다.\n");
    writer.append("게임이 종료 되었습니다.");
    System.out.println(writer.toString());
    clearBuffer();
  }
}
