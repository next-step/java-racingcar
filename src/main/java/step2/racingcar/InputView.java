/*
 * Description : 자동차경주에서 사용자에게 레이싱조건을 표시하고 입력받는 역할을 담당
 */

package step2.racingcar;

import java.util.Scanner;

public class InputView {

  Scanner scanner = new Scanner(System.in);

  public int createCar() throws IllegalArgumentException {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  public int createRacingLap() throws IllegalArgumentException {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
