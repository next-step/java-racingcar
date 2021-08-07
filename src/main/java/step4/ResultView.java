package step4;

import java.util.ArrayList;

public class ResultView {

  private static final String RESULT_DIVIDER = "\n";

  public static void printResultTitle() {
    System.out.println("\n실행 결과");
  }

  public static void printCurrentRoundResult(ArrayList<Car> carList) {
    for (Car car : carList) {
      System.out.print(car.getName() + " : ");
      printCarLocation(car);
    }
  }

  public static void printRoundDivider() {
    System.out.print(RESULT_DIVIDER);
  }

  public static void printWinnerList(final String[] winnerList) {
    if (winnerList.length == 0) {
      System.out.println("우승자가 없습니다.");
      return;
    }
    System.out.print(winnerList[0]);
    for (int i = 1; i < winnerList.length; i++) {
      System.out.print(", " + winnerList[i]);
    }
    System.out.println("가 최종 우승했습니다.");
  }

  private static void printCarLocation(Car car) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < car.getLocation(); i++) {
      sb.append("-");
    }
    System.out.println(sb);
  }
}
