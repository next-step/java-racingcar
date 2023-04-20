package study.domain.racingGame;

public class GameScreen {

  public void print(String printTxt) {
    System.out.println(printTxt);
  }

  public void printResult(int distance) {
    print(convertCarDistanceToDash(distance));
  }

  public void printRaceResult(Cars racingCar, GameBoard raceBoard) {
    for (int carIdx = 0; carIdx < racingCar.getTotalCarsCount(); carIdx++) {
      printResult(raceBoard.getResult(carIdx));
    }
    print("");
  }

  private String convertCarDistanceToDash(int carDistance) {
    String result = "";
    for (int i = 0; i < carDistance; i++) {
      result += "-";
    }
    return result;
  }
}
