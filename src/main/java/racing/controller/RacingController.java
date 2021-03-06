package racing.controller;

import java.util.List;
import racing.model.RacingCar;
import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

  private RacingGame racingGame;
  private ResultView resultView;
  private InputView inputView;
  private int gameTrun;


  public RacingController() {
    setUpGame();
    play();
  }

  /**
   * InputView 에서 자동차 갯수와 게임 실행 횟수를 입력받아 게임을 설정함
   */
  public void setUpGame() {
    inputView = new InputView();
    racingGame = new RacingGame();

    int[] carCountAndTurnCount = inputView.init();
    this.gameTrun = carCountAndTurnCount[1];
    racingGame.setUp(carCountAndTurnCount[0]);
  }

  /**
   * 게임 시작 메서드 1 턴씩 진행하며 게임이 끝날때까지 반복된다.
   */
  public void play() {
    resultView = new ResultView();
    for (int i = 0; i < gameTrun; i++) {
      List<Integer> randomValue = racingGame.createRandomValue();
      List<RacingCar> movedCarList = racingGame.moveAndStop(randomValue);
      resultView.turnResultView(movedCarList);
    }
  }


  public static void main(String[] args) {
    new RacingController();
  }

}
