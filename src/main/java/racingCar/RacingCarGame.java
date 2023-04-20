package racingCar;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.car.RacingCar;
import racingCar.exception.NotAllowedGameSettingException;
import racingCar.random.MoveAckGenerator;
import racingCar.view.RacingCarGameResultView;
import util.CollectionUtils;

public final class RacingCarGame {

  private final List<RacingCar> racingCars;
  private final RacingCarGameResultView resultView;

  private final MoveAckGenerator randomMoveAckGenerator;

  public RacingCarGame(List<String> carNames, RacingCarGameResultView resultView, MoveAckGenerator randomMoveAckGenerator) {
    this.randomMoveAckGenerator = randomMoveAckGenerator;
    this.resultView = resultView;
    this.racingCars = generateRacingCars(carNames);
  }

  private List<RacingCar> generateRacingCars(List<String> carNames) {
    if (CollectionUtils.isEmpty(carNames)) {
      throw new NotAllowedGameSettingException("자동차 개수가 최소 하나 이상이여야합니다.");
    }

    return carNames.stream()
        .map(carName -> new RacingCar(carName, randomMoveAckGenerator))
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
        .filter(car -> car.isPosition(maxPosition))
        .collect(Collectors.toList());
  }

  private int getMaxPositionOfGame() {
    return racingCars.stream()
        .mapToInt(RacingCar::getPosition)
        .max()
        .orElseThrow(RuntimeException::new);
  }
}
