package racingCar;

import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

  @Test
  @DisplayName("n대의 자동차를 m번 시도하기 위한 n, m을 입력 받는다")
  public void racingCarTest() {
    Scanner scanner = new Scanner(System.in);
    int carCount = scanner.nextInt();
    int moveCount = scanner.nextInt();

    RacingCarGame racingCarGame = new RacingCarGame(carCount, moveCount);
    racingCarGame.start();
  }
}
