package camp.nextstep.racingcar.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int getCountOfCar() {
    System.out.println("자동차 대수는 몇 대인가요?");
    return scanner.nextInt();
  }

  public static int getRounds() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

}
