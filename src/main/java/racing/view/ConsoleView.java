package racing.view;

import racing.domain.RacingGame;

public class ConsoleView {

  private ConsoleInputView consoleInputView;

  public ConsoleView() {
    this.consoleInputView = new ConsoleInputView();
  }

  public void main() {

    String inputCarNames = consoleInputView.inputCarNames();

    int moveCount = consoleInputView.inputMoveCount();

    RacingGame racingGame = new RacingGame();
    racingGame.startGame(inputCarNames, moveCount);
  }
}
