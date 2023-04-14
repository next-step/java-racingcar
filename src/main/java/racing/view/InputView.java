package racing.view;

import java.util.Scanner;

/**
 * 사용자 입력 (InputView)
 *     - 책임
 *       - 자동차 대수를 입력받는다.
 *       - 자동차 이동 횟수를 입력받는다.
 */
public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static String scanCarsName() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return scanner.nextLine();
  }


  public static int scanNumberOfMovements() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
