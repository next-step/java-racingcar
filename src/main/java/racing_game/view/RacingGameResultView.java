package racing_game.view;

import java.util.List;
import racing_game.model.Car;

public class RacingGameResultView {
  private final static String RESULT_BEGIN_MESSAGE = "\n실행결과";
  private final static String SYMBOL_DISTANCE = "-";
  private final static String RESULT_WINNER_MESSAGE = "(이)가 최종우승했습니다.";

  /**
   * 메세지 "실행결과" 출력
   */
  public static void printResultBeginMessage() {
    System.out.println(RESULT_BEGIN_MESSAGE);
  }

  /**
   * 입력 받은 이름과 거리에 따라 대쉬(-) 출력 <br/>
   * 
   * e.g. name : -
   * 
   * @param name : String, 출력할 이름
   * @param distance : int 출력할 거리
   */
  public static void printNameAndDistance(String name, int distance) {
    StringBuilder message = new StringBuilder(name + " : ");

    for (int i = 0; i < distance; i++) {
      message.append(SYMBOL_DISTANCE);
    }

    System.out.println(message.toString());
  }

  /**
   * 자동차들의 이름과 거리 출력
   * 
   * @param racingCarList : 출력할 자동차 목록
   */
  public static void printNameAndDistancesOfRacingCarList(List<Car> racingCarList) {
    for (Car racingCar : racingCarList) {
      printNameAndDistance(racingCar.getName(), racingCar.getDistance());
    }

    System.out.println();
  }

  /**
   * 자동차 경주의 우승자 출력
   * 
   * @param racingCarList : 출력할 자동차 목록
   */
  public static void printWinner(List<Car> winnerList) {
    StringBuffer message = new StringBuffer();

    for (Car winner : winnerList) {
      message.append(winner.getName() + ", ");
    }

    message.delete(message.length() - 2, message.length());
    message.append(RESULT_WINNER_MESSAGE);

    System.out.println(message.toString());
  }
}
