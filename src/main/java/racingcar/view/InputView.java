package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in); // 단일 Scanner 유지

  public static List<String> inputCarName() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String inputName = scanner.nextLine().trim();
    return Arrays.asList(inputName.split(","));
  }

  public static int inputRound() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    int round = Integer.parseInt(scanner.nextLine().trim());
    return round;
  }

  public static void closeScanner() {
    scanner.close();
  }
}
