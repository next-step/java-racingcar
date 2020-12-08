package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.Scanner;

public class RacingGameView {

  private static final Scanner scanner = new Scanner(System.in);
  public static final String DISTANCE_MARK = "-";

  public static String getCarNamesFromUser() {
    System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    return scanner.nextLine();
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
