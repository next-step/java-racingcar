package step5.view;

import java.util.Scanner;

public class InputView {
  private Scanner scanner;

  private final static String INPUT_REQUIRE_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private final static String INPUT_REQUIRE_ATTEMPT = "시도할 회수는 몇 회 인가요?";

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public String inputCarNames() {
    System.out.println(INPUT_REQUIRE_CAR);
    return scanner.nextLine();
  }

  public int inputPeriod() {
    System.out.println(INPUT_REQUIRE_ATTEMPT);
    return scanner.nextInt();
  }
}
