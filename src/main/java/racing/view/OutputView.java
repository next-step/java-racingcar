package racing.view;

import java.util.List;
import racing.domain.Car;

public class OutputView {

  public static void println() {
    System.out.println();
  }

  public static void carsName() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
  }

  public static void tryNumber() {
    System.out.println("시도할 회수는 몇 회 인가요?");
  }

  public static void resultText() {
    System.out.println("\n실행 결과");
  }

  public static void moveDistance(List<Car> cars) {
    for (Car car : cars) {
      moveDistance(car.name(), car.moveDistance());
    }
  }

  public static void moveDistance(String carName, int number) {
    System.out.print(carName + " : ");
    for (int i = 0; i < number; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void winner(String names) {
    System.out.println(names + "가 최종 우승했습니다.");
  }
}
