package racingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingCar.car.RacingCar;
import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveServiceLocator;
import racingCar.view.RacingCarGameResultView;
import util.RandomUtils;

public final class RacingCarGame {

  private final List<RacingCar> racingCars;
  private final RacingCarGameResultView resultView;

  private final RacingCarMoveServiceLocator racingCarMoveServiceLocator;

  public RacingCarGame(int carCnt, RacingCarGameResultView resultView, List<RacingCarMoveDirectionStrategy> inGameSupportCarMoveDirections) {
    this.racingCarMoveServiceLocator = new RacingCarMoveServiceLocator(inGameSupportCarMoveDirections);
    this.racingCars = generateRacingCars(carCnt);
    this.resultView = resultView;
  }

  private List<RacingCar> generateRacingCars(int carCnt) {
    return IntStream.rangeClosed(1, carCnt)
            .mapToObj(carId -> new RacingCar(carId, racingCarMoveServiceLocator))
            .collect(Collectors.toUnmodifiableList());
  }

  public void play (int moveTryCnt) {
    for (long moveCnt = 0; moveCnt < moveTryCnt ; moveCnt++) {
      moveAllRacingCars(racingCars);
      resultView.storeSnapShotOfMoveCnt(racingCars);
    }

    resultView.printAllSnapShot();
  }

  private void moveAllRacingCars(List<RacingCar> racingCarList) {
    racingCarList.forEach(car -> car.moveIfPossible(RandomUtils.getRandomSinglePositiveDigit()));
  }
}
