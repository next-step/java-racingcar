package racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

  public int[] init() {
    Scanner scan = new Scanner(System.in);
    int racingCarCount = 0;
    int turnCount = 0;
    try {
      System.out.println("자동차 대수는 몇 대 인가요?");
      racingCarCount = scan.nextInt();
      System.out.println("시도할 횟수는 몇 회 인가요?");
      turnCount = scan.nextInt();
    } catch (InputMismatchException e) {
      reStart();
    } finally {
      scan.close();
      return new int[]{racingCarCount, turnCount};
    }
  }

  public int[] reStart() {
    System.out.println("입력하신 값은 올바른 값이 아닙니다. 다시 입력해주세요");
    return init();
  }
}
