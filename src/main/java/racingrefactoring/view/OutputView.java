package racingrefactoring.view;

import java.util.List;
import racingrefactoring.domain.CarGroup;
import racingrefactoring.domain.Winners;

public class OutputView {

  public static void printCarGroup(CarGroup carGroup) {
    carGroup.getCars().forEach(car -> {
      printlnCarNameAndPosition(car.getName(), car.getPosition());
    });
  }

  private static void printlnCarNameAndPosition(String name, int position) {
    System.out.println(name + " : " + "-".repeat(position));
  }

  public static void printResultMessage() {
    System.out.println("실행 결과");
  }

  public static void printWinners(Winners winners) {
    List<String> winnerNames = winners.winner();

    System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
  }

  public static void printEmptyLine() {
    System.out.println("");
  }
}
