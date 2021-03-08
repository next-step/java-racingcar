package racingcar;

import racingcar.view.InputView;

public class Main {

  public static void main(String[] args) {

    RacingGame racingGame = new RacingGame();
    racingGame.readyGame(InputView.inputCount("자동차 대수는 몇 대 인가요?"));
    racingGame.run(InputView.inputCount("시도할 회수는 몇 회 인가요?"));
  }

}
