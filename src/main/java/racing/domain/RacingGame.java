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
    while (tryCnt.canRace()) {
      game.playRound();
      ResultView.printRoundResult(game.getParticipants());
      tryCnt.doRace();
    }
    ResultView.printWinner(game.getWinners());
  }
}
