package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.random.NumberGenerator;

public class Racing {
  private List<Car> cars;
  private final int round;
  private final NumberGenerator numberGenerator;

  public Racing(int carCount, int round, NumberGenerator numberGenerator) {
    this.cars = new ArrayList<>();
    this.round = round;
    this.numberGenerator = numberGenerator;

    prepareCars(carCount);
  }

  private void prepareCars(int carCount) {
    this.cars = IntStream.range(0, carCount)
        .mapToObj(Car::new)
        .collect(Collectors.toList());
  }

  public List<RacingBoard> start() {
    return IntStream.range(0, round)
        .mapToObj(this::racingRound)
        .collect(Collectors.toList());
  }

  private RacingBoard racingRound(int round) {
    RacingBoard racingBoard = new RacingBoard(round);

    cars.stream()
        .filter(car -> isEnabledMove()) // 이동 가능 여부 체크
        .peek(Car::move)                    // 이동
        .map(Car::getPosition)              // 이동 후 위치 가져오기
        .collect(Collectors.toList())
        .forEach(racingBoard::record);      // 레이싱 보드에 기록

    return racingBoard;
  }

  public boolean isEnabledMove() {
    return numberGenerator.generateNumber() >= 4;
  }

  public List<Car> getCars() {
    return cars;
  }
}
