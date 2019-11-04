package step3.racingcarWinner;

import java.util.List;

public class ResultView {

  private RacingGame racingGame;

  private String winner = "";

  public ResultView(RacingGame racingGame) {
    this.racingGame = racingGame;
  }

  public static void printCurrentCarPosition(Car car) {
    System.out.println("");
    System.out.print(car.getName() + ":");
    for (int i = 0; i < car.getPosition(); i++) {
      System.out.print("-");
    }
  }

  public void printFinalWinner(List<Car> carList) {
    for (Car car : carList) {
      appendWinner(car);
    }
    System.out.println(winner + "가 최종 우승했습니다.");
  }

  private void appendWinner(Car car) {
    if (car.isFinalWinner()) {
      generateWinnerText(car.getName());
    }
  }

  private void generateWinnerText(String name) {
    if (!winner.equals("")) {
      winner += ", " + name;
    }

    if (winner.equals("")) {
      winner += name;
    }
  }
}
