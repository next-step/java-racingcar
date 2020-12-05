package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.Scanner;

public class RacingGameView {

  private static final Scanner scanner = new Scanner(System.in);
  public static final String DISTANCE_MARK = "-";

  public static int getNumberOfCarFromUser() {
    System.out.print("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  public static int getGameCountFromUser() {
    System.out.print("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

  public static void printRacingGameResult(Cars carList) {
    for (Car car : carList.getCars()) {
      System.out.println(makeRacingGameResult(car.getDistance()));
    }
    System.out.println();
  }

  private static StringBuilder makeRacingGameResult(int distance) {
    StringBuilder racingGameResult = new StringBuilder();
    for (int i = 0; i < distance; i ++) {
      racingGameResult.append(DISTANCE_MARK);
    }
    return racingGameResult;
  }
}
