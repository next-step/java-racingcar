package step3;

import java.util.List;

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
    StringBuffer message = new StringBuffer(name + " : ");

    for (int i = 0; i < distance; i++) {
      message.append(SYMBOL_DISTANCE);
    }

    System.out.println(message.toString());
  }

  /**
   * 입력 받은 거리에 따라 대쉬(-) 출력
   * 
   * @param distance : int 출력할 거리
   */
  public static void printDistance(int distance) {
    StringBuffer message = new StringBuffer();

    for (int i = 0; i < distance; i++) {
      message.append(SYMBOL_DISTANCE);
    }

    System.out.println(message.toString());
  }

  /**
   * 자동차들의 거리 출력
   * 
   * @param racingCarList : 출력할 자동차 목록
   */
  public static void printDistancesOfRacingCarList(List<Car> racingCarList) {
    for (Car racingCar : racingCarList) {
      printDistance(racingCar.getDistance());
    }

    System.out.println();
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
   * 자동차 경주의 우승자 출력<br/>
   * 
   * 출력 시점에 가장 멀리간 자동차를 출력한다.
   * 
   * @param racingCarList : 출력할 자동차 목록
   */
  public static void printWinner(List<Car> racingCarList) {
    StringBuffer message = new StringBuffer();

    racingCarList.stream().filter(car -> {
      return car.getDistance() == racingCarList.stream().max((car1, car2) -> car1.compareTo(car2))
          .get().getDistance();
    }).forEach(winner -> {
      message.append(winner.getName() + ", ");
    });

    message.delete(message.length() - 2, message.length());
    message.append(RESULT_WINNER_MESSAGE);

    System.out.println(message.toString());
  }
}
