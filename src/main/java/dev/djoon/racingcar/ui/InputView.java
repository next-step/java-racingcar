package dev.djoon.racingcar.ui;

import dev.djoon.racingcar.RacingCarGame;
import java.io.InputStream;
import java.util.Scanner;

public class InputView {

  private Scanner scanner;

  public InputView(InputStream is) {
    this.scanner = new Scanner(is);
  }

  public int inputCarQuantity() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int quantity = Integer.parseInt(scanner.nextLine());
    return quantity;
  }

  public int inputLoopTimes() {
    System.out.println("시도할 횟수는 몇 회 인가요?");
    int loopTimes = Integer.parseInt(scanner.nextLine());
    return loopTimes;
  }

  public void close() {
    this.scanner.close();
  }

}
