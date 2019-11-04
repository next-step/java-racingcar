/*
 * Description : 자동차경주에서 사용자에게 레이싱조건을 표시하고 입력받는 역할을 담당
 */

package step3.racingcarWinner;

import java.util.Scanner;

public class InputView {

  Scanner scanner = new Scanner(System.in);

  public String carNames() throws IllegalArgumentException {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return scanner.nextLine();
  }

  public int racingLap() throws IllegalArgumentException {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
