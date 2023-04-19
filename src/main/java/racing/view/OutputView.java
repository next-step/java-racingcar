package racing.view;

import racing.race.Car;
import racing.race.Cars;

public class OutputView {

  public static void prinln() {
    System.out.println();
  }

  public static void getCarsName() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
  }

  public static void getTryNumger() {
    System.out.println("시도할 회수는 몇 회 인가요?");
  }

  public static void result() {
    System.out.println("\n실행 결과");
  }

  public static void moveDistance(String carName, int number) {
    System.out.print(carName + " : ");
    for (int i = 0; i < number; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void winner(Cars cars) {
    StringBuilder winnerNames = new StringBuilder();
    for (Car car : cars.getWinnerCars()) {
      winnerNames.append(car.name()).append(", ");
    }
    System.out.println(winnerNames.delete(winnerNames.length() - 2, winnerNames.length())
        + "가 최종 우승했습니다.");
  }
}
