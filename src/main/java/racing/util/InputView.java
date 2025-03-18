package racing.util;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int showCarCountInput() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return SCANNER.nextInt();
  }

  public static String showCarNamesInput() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return SCANNER.nextLine();
  }

  public static int showSimulateCountInput() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return SCANNER.nextInt();
  }
}
