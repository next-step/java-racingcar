package study.domain.racingGame;

public class GameScreen {

  private static String CAR_NAME_INPUT_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static String CAR_MOVE_COUNT_INPUT_TEXT = "시도할 회수는 몇 회 인가요?";

  public void printCarMoveCountInputText() {
    print(CAR_MOVE_COUNT_INPUT_TEXT);
  }

  public void printCarNameInputText() {
    print(CAR_NAME_INPUT_TEXT);
  }

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
