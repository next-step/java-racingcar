package study.domain.racingGame;

import java.util.LinkedList;
import java.util.List;

public class GameScreen {

  private static String CAR_NAME_INPUT_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static String CAR_MOVE_COUNT_INPUT_TEXT = "시도할 회수는 몇 회 인가요?"; //가 최종 우승했습니다.

  private static String WINNER_OUTPUT_TEXT = "가 최종 우승했습니다.";

  public void printCarMoveCountInputText() {
    println(CAR_MOVE_COUNT_INPUT_TEXT);
  }

  public void printCarNameInputText() {
    println(CAR_NAME_INPUT_TEXT);
  }

  public void println(String printTxt) {
    System.out.println(printTxt);
  }

  public void print(String printTxt) {
    System.out.print(printTxt);
  }

  private void printCarDistance(int distance) {
    println(convertCarDistanceToDash(distance));
  }

  public void printRaceResult(Cars racingCar, GameBoard raceBoard) {
    for (Car car : racingCar) {
      printCarDistance(raceBoard.getResult(car.getCarName()));
    }

    println("");
  }

  private String convertCarDistanceToDash(int carDistance) {
    String result = "";
    for (int i = 0; i < carDistance; i++) {
      result += "-";
    }
    return result;
  }

  public void printRaceResultWithName(Cars racingCar, GameBoard raceBoard) {
    for (Car car : racingCar) {
      print(car.getCarName() + " : ");
      printCarDistance(raceBoard.getResult(car.getCarName()));
    }

    println("");
  }

  public void printWinners(CarNames winnerNames) {
    List<String> printWinnerNameList = new LinkedList<>();
    for (String carName : winnerNames) {
      printWinnerNameList.add(carName);
    }
    print(String.join(", ", printWinnerNameList));
    println(WINNER_OUTPUT_TEXT);
  }
}
