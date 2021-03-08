package dev.djoon.racingcar;

import dev.djoon.racingcar.ui.InputView;
import dev.djoon.racingcar.util.RandomNumbers;

public class GameApp {
  public static void main(String[] args) {

    InputView inputView = new InputView(System.in);
    final String[] carOwnerNames = inputView.inputCarWithOwner();
    final int loopTimes = inputView.inputLoopTimes();
    inputView.close();

    RacingCarGame game = new RacingCarGame(carOwnerNames, loopTimes);
    game.start(new RandomNumbers());
  }
}
