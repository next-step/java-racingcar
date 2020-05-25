package step5.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCAN = new Scanner(System.in);

  private InputView() { }

  public static String[] inputCars () {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return SCAN.nextLine().split(",");
  }

  public static int inputTime () {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return Integer.parseInt(SCAN.nextLine());
  }
}
