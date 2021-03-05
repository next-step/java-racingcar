package racing.view;

import java.util.Scanner;

public class InputView {

  public int[] setUp() {
    Scanner scan = new Scanner(System.in);

    System.out.println("자동차 대수는 몇 대 인가요?");
    int racingCarCount = scan.nextInt();
    System.out.println("시도할 횟수는 몇 회 인가요?");
    int turnCount = scan.nextInt();

    return new int[]{racingCarCount, turnCount};
  }
}
