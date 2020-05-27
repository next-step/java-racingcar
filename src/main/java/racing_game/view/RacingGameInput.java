package racing_game.view;

import java.util.Scanner;

public class RacingGameInput {

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * 자동차 이름 입력 메세지 출력 후 스캐너 호출
   * <p>
   * 이름은 쉼표(,)로 구분한다.
   *
   * @return String[], 자동차 이름 목록 배열
   */
  public static String[] getNameOfCarsByScanner() {
    RacingGameInputView.printNameOfCarsInputMessage();

    return scanner.nextLine().split(",");
  }

  /**
   * 횟수 입력 메세지 출력 후 스캐너 호출
   *
   * @return int, 반복 횟수
   */
  public static int getTimeByScanner() {
    RacingGameInputView.printTimeInputMessage();

    return scanner.nextInt();
  }
}
