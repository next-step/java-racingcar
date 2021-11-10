package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

  private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
  private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

  private List<RacingCar> racingCarList;

  private InputView inputView;
  private ResultView resultView;

  private int tryCount;

  public RacingCarGame() {
    racingCarList = new ArrayList<>();
    inputView = new InputView();
    resultView = new ResultView();
  }

  public void startWithUserInput() {
    start(inputView.inputByUser(QUESTION_CAR_COUNT), inputView.inputByUser(QUESTION_TRY_COUNT));
  }

  public void start(int carCount, int tryCount) {
    createCars(carCount);
    this.tryCount = tryCount;

    race();
  }

  private void createCars(int carCount) {
    for (int i = 0; i < carCount; i++) {
      racingCarList.add(new RacingCar());
    }
  }

  public void race() {
    for (int currentMoveCount = 0; currentMoveCount < tryCount; currentMoveCount++) {
      moveAllCars();
      resultView.printAllCarsStatus(racingCarList);
    }
  }

  public void moveAllCars() {
    racingCarList.forEach(e -> e.tryMove(new Random().nextInt(10)));
  }
}
