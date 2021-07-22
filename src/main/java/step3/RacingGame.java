package step3;

import java.util.List;

public class RacingGame {

  private final InputView inputView;
  private final Racing racing;
  private final ResultView resultView;

  public RacingGame() {
    this.inputView = new InputView();
    this.racing = new Racing();
    this.resultView = new ResultView();
  }

  public void start() {
    inputView.render();
    final Input input = inputView.getInput();
    final List<Result> result = racing.race(input);
    resultView.render(result);
  }

  public static void main(String[] args) {
    RacingGame game = new RacingGame();
    game.start();
  }

}
