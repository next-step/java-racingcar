package step3;

import java.util.Scanner;

public class InputView {
  Scanner scanner = new Scanner(System.in);

  int setCarCount() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  int setMoveCount() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }

}
