package racingcar;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    RacingCarGame game = new RacingCarGame(new Random());

    game.getCarsReady();
    game.getRepetitionReady();

    game.startRacing();

    game.displayResult();
  }
}
