package racingCar;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.car.RacingCar;
import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveServiceLocator;
import racingCar.exception.NotAllowedGameSettingException;
import racingCar.view.RacingCarGameResultView;
import util.CollectionUtils;
import util.RandomUtils;

public final class RacingCarGame {

  private final List<RacingCar> racingCars;
  private final RacingCarGameResultView resultView;

  private final RacingCarMoveServiceLocator racingCarMoveServiceLocator;

  public RacingCarGame(List<String> carNames, RacingCarGameResultView resultView, List<RacingCarMoveDirectionStrategy> inGameSupportCarMoveDirections) {
    this.racingCarMoveServiceLocator = new RacingCarMoveServiceLocator(inGameSupportCarMoveDirections);
    this.racingCars = generateRacingCars(carNames);
    this.resultView = resultView;
  }

  private List<RacingCar> generateRacingCars(List<String> carNames) {
    if (CollectionUtils.isEmpty(carNames)) {
      throw new NotAllowedGameSettingException("자동차 개수가 최소 하나 이상이여야합니다.");
    }

    return carNames.stream()
        .map(carName -> new RacingCar(carName, racingCarMoveServiceLocator))
        .collect(Collectors.toUnmodifiableList());
  }

  public void play (int moveTryCnt) {
    for (long moveCnt = 0; moveCnt < moveTryCnt ; moveCnt++) {
      moveAllRacingCars(racingCars);
      resultView.storeSnapShotOfMoveCnt(racingCars);
    }

    resultView.printAllSnapShot();
    resultView.printWinners(getWinners());
  }

  private void moveAllRacingCars(List<RacingCar> racingCarList) {
    racingCarList.forEach(RacingCar::moveIfPossible);
  }

  private List<RacingCar> getWinners() {
    final int maxPosition = getMaxPositionOfGame();
    return racingCars.stream()
        .filter(racingCar -> racingCar.getPosition() == maxPosition)
        .collect(Collectors.toList());
  }

  private int getMaxPositionOfGame() {
    return racingCars.stream()
        .mapToInt(RacingCar::getPosition)
        .max()
        .orElseThrow(RuntimeException::new);
  }
}
