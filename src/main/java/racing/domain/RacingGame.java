package racing.domain;

import racing.ui.ResultView;

public class RacingGame {
  private Game game;
  private final int tryCnt;

  public RacingGame(Game game, int tryCnt) {
    this.game = game;
    this.tryCnt = tryCnt;
  }

  public void play() {
    ResultView.printResultMessage();
    for (int i = 0; i < tryCnt; i++) {
      game.playRound();
      ResultView.printRoundResult(game.getParticipants());
    }
    ResultView.printWinner(game.getWinners());
  }
}
