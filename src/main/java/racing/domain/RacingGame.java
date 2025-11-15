package racing.domain;

import racing.ui.ResultView;

public class RacingGame {

  private final RoundCount tryCnt;
  private final Game game;

  public RacingGame(Game game, RoundCount tryCnt) {
    this.game = game;
    this.tryCnt = tryCnt;
  }

  public void play() {
    ResultView.printResultMessage();
    for (int i = 0; i < tryCnt.getCount(); i++) {
      game.playRound();
      ResultView.printRoundResult(game.getParticipants());
    }
    ResultView.printWinner(game.getWinners());
  }
}
