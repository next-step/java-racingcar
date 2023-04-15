package racingcar.domain;

import racingcar.repository.NormalMoveStrategy;
import racingcar.repository.MoveStrategy;
import racingcar.view.ResultView;

public class Racing {
  private RacingCars racing;
  private int numberOfTrials;

  public Racing(RacingCars racingCars, int numberOfTrials) {
    this.racing = racingCars;
    this.numberOfTrials = numberOfTrials;
  }

  // 전체 자동차에서 각각의 자동차들의 전진 시도
  public void tryToMoveCars() {
    for (RacingCar racingCar : this.racing.getRacingCars()) {
        racingCar.tryToMove(defaultRacingMoveStrategy());
    }

  }

  // racing 진행
  public void startRacing() {
    ResultView resultView = new ResultView(this.numberOfTrials);
    // \n, "실행결과" 출력
    resultView.printByRacingResult();

    for (int i = 0; i < this.numberOfTrials; i++) {
      // 전체 자동차에서 각각의 자동차들의 전진 시도
      tryToMoveCars();

      // racing에서 trial 마다 출력
      resultView.printByRacingTrials(this.racing.getRacingCars(), i);
    }
  }

  // racing에서 자동차 전진 시도 횟수
  public int getNumberOfTrials() {
    return this.numberOfTrials;
  }

  // racing 가져오기
  public RacingCars getRacing() {
    return this.racing;
  }

  public static MoveStrategy defaultRacingMoveStrategy() {
    return new NormalMoveStrategy();
  }

}