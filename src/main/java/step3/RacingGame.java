package step3;

import java.util.List;

public class RacingGame {

  private final InputView inputView;
  private final Racing racing;

  public RacingGame() {
    this.inputView = new InputView();
    this.racing = new Racing();
  }

  public void start() {
    inputView.render();
    final Input input = inputView.getInput();
    final List<Result> results = racing.race(input);
    final ResultView resultView = new ResultView(results);
    resultView.render();
  }

  public static void main(String[] args) {
    RacingGame game = new RacingGame();
    game.start();
  }

}
