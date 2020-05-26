package step3;

import java.util.List;

public class RacingGame implements Game {
  private String[] carNameArr;
  // private int numberOfCars;
  private int time;
  private List<Car> racingCarList;

  public RacingGame(String[] carNameArr, int time) {
    this.carNameArr = carNameArr;
    this.time = time;
  }

  /**
   * 지정된 횟수만큼 게임 진행
   * 
   * 게임 진행 시 racingCar 임의 이동
   */
  public void play() {
    racingCarList = RacingCarFactory.createRacingCarList(carNameArr);
    RacingGameResultView.printResultBeginMessage();

    for (int i = 0; i < time; i++) {
      moveRacingCars(racingCarList);
      RacingGameResultView.printNameAndDistancesOfRacingCarList(racingCarList);
    }

    RacingGameResultView.printWinner(racingCarList);
  }

  /**
   * racingCarList에 있는 racingCar들을 임의로 이동시킨다.
   * 
   * @param racingCarList : List&lt;Car&gt; 이동시킬 자동차 목록
   */
  private void moveRacingCars(List<Car> racingCarList) {
    for (Car racingCar : racingCarList) {
      racingCar.move();
    }
  }
}


