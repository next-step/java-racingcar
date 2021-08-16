package step45;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static String[] getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String[] carNames = scanner.nextLine().split(",");
    trim(carNames);
    return carNames;
  }

  public static int getNumOfMove() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

  private static void trim(String[] carNames) {
    for (int i = 0; i < carNames.length; i++){
      carNames[i] = carNames[i].trim();
    }
  }
}
