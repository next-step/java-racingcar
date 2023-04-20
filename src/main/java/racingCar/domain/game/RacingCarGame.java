package racingCar.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.car.RacingCar;
import racingCar.domain.game.print.BaseRacingCarGameSnapShotExtractor;
import racingCar.domain.game.print.RacingCarGameSnapShotExtractor;
import racingCar.exception.NotAllowedGameSettingException;
import racingCar.domain.game.move.MoveAckGenerator;
import util.CollectionUtils;

public final class RacingCarGame {

  private final List<RacingCar> racingCars;
  private final MoveAckGenerator randomMoveAckGenerator;
  private final RacingCarGameSnapShotExtractor snapShotExtractor;

  public RacingCarGame(List<String> carNames, MoveAckGenerator moveAckGenerator) {
    this.randomMoveAckGenerator = moveAckGenerator;
    this.racingCars = generateRacingCars(carNames);
    this.snapShotExtractor = new BaseRacingCarGameSnapShotExtractor();
  }

  private List<RacingCar> generateRacingCars(List<String> carNames) {
    if (CollectionUtils.isEmpty(carNames)) {
      throw new NotAllowedGameSettingException("자동차 개수가 최소 하나 이상이여야합니다.");
    }

    return carNames.stream()
        .map(carName -> new RacingCar(carName, randomMoveAckGenerator))
        .collect(Collectors.toUnmodifiableList());
  }

  public RacingCarGameResult play (int moveTryCnt) {
    List<String> snapShots = new ArrayList<>(moveTryCnt);
    for (long moveCnt = 0; moveCnt < moveTryCnt ; moveCnt++) {
      moveAllRacingCars(racingCars);
      snapShots.add(snapShotExtractor.extractSnapShot(racingCars));
    }

    return new RacingCarGameResult(getWinners(), snapShots);
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
