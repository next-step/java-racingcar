package racing.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racing.model.RacingCar;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

  private final int racingCarCount;
  private final int turnCount;
  private List<RacingCar> carList;
  Random random = new Random();

  public RacingController() {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    int[] carCountAndTurnCount = inputView.setUp();
    this.racingCarCount = carCountAndTurnCount[0];
    this.turnCount = carCountAndTurnCount[1];
    setUpGame();
    startGame(resultView);
  }

  public void setUpGame() {
    carList = new ArrayList<>();
    for (int i = 0; i < racingCarCount; i++) {
      carList.add(new RacingCar(0));
    }
  }

  public List<Integer> createRandomValue() {
    List<Integer> randomValue = new ArrayList<>();
    for (int i = 0; i < racingCarCount; i++) {
      randomValue.add(random.nextInt());
    }
    return randomValue;
  }

  public void moveAndStop() {
    List<Integer> randomValue = createRandomValue();
    for (int i = 0; i < carList.size(); i++) {
      carList.get(i).move(randomValue.get(i));
    }
  }

  public void startGame(ResultView resultView) {
    for (int count = 0; count < turnCount; count++) {
      moveAndStop();
      resultView.moveResult(carList);
    }
  }

  public static void main(String[] args) {
    new RacingController();
  }

}
