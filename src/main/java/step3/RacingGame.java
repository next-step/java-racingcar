package step3;

import java.util.List;
import step3.domain.Input;
import step3.domain.Racing;
import step3.domain.Result;
import step3.view.InputView;
import step3.view.ResultView;

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
