package step3.view;

import java.util.Scanner;

public class RacingGameInputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static String getCarNamesFromUser() {
    System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
    return scanner.nextLine();
  }

  public static int getGameCountFromUser() {
    System.out.print("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

}
