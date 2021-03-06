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
   * InputView ���� �ڵ��� ������ ���� ���� Ƚ���� �Է¹޾� ������ ������
   */
  public void setUpGame() {
    inputView = new InputView();
    racingGame = new RacingGame();

    int[] carCountAndTurnCount = inputView.init();
    this.gameTrun = carCountAndTurnCount[1];
    racingGame.setUp(carCountAndTurnCount[0]);
  }

  /**
   * ���� ���� �޼��� 1 �Ͼ� �����ϸ� ������ ���������� �ݺ��ȴ�.
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
