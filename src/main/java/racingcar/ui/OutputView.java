package racingcar.ui;

import racingcar.domain.Cars;

public class OutputView {

  private final StringBuilder writer = new StringBuilder();

  public void printCarPosition(Cars cars, int currentRound) {
    writer.append(currentRound).append("회 라운드 결과입니다.\n");
    writer.append(cars.currentCarsPosition());
<<<<<<< HEAD
    System.out.println(writer);
=======
    System.out.println(writer.toString());
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
    clearBuffer();
  }

  public void printInitialCarPosition(Cars cars) {
    writer.append("초기 자동차 위치 결과입니다.\n");
    writer.append(cars.currentCarsPosition());
<<<<<<< HEAD
    System.out.println(writer);
=======
    System.out.println(writer.toString());
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
    clearBuffer();
  }


  private void clearBuffer() {
    writer.setLength(0);
  }

<<<<<<< HEAD
  public void endGame(Cars cars) {
    writer.append("우승자는 ").append(cars.getWinner()).append(" 입니다.\n");
    writer.append("게임이 종료 되었습니다.");
    System.out.println(writer);
    clearBuffer();
=======
  public void endGame() {
    System.out.println("게임이 종료 되었습니다.");
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }
}
