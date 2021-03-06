package dev.djoon.racingcar.ui;

import dev.djoon.racingcar.RacingCarGame;
import java.io.InputStream;
import java.util.Scanner;

public class InputView {

  private Scanner sc;

  public InputView(InputStream is) {
    this.sc = new Scanner(is);
  }

  public void inputCarQuantity(RacingCarGame game) {
    System.out.println("자동차 대수는 몇 대 인가요?");
    int quantity = Integer.parseInt(sc.nextLine());
    game.setCarQuantity(quantity);
  }

  public void inputLoopTimes(RacingCarGame game) {
    System.out.println("시도할 횟수는 몇 회 인가요?");
    int loopTimes = Integer.parseInt(sc.nextLine());
    game.setLoopTimes(loopTimes);
  }

}
