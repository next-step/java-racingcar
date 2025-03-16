package racingcar;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Racing {
  private ArrayList<Car> cars;
  private ArrayList<RacingBoard> racingBoards;

  private final int round;

  private final NumberGenerator numberGenerator;

  public Racing(int carCount, int round, NumberGenerator numberGenerator) {
    this.cars = new ArrayList<>();
    this.racingBoards = new ArrayList<>();
    this.round = round;
    this.numberGenerator = numberGenerator;

    prepareCars(carCount);
  }

  private void prepareCars(int carCount) {
    IntStream.range(0, carCount).mapToObj(Car::new).forEach(this.cars::add);
  }

  public void racingRound(int round) {
    RacingBoard racingBoard = new RacingBoard(round);

    cars.stream()
        .peek(car -> {
          if (isEnabledMove())
            car.move();
        }) // 이동 조건 체크 후 이동
        .map(Car::getPosition) // 자동차 위치 가져오기
        .forEach(racingBoard::record); // 위치 기록

    racingBoards.add(racingBoard);
  }

  public void racing() {
    IntStream.range(0, round).forEach(this::racingRound);
  }

  public boolean isEnabledMove() {
    return numberGenerator.generateNumber() >= 4;
  }

  public ArrayList<Car> getCars() {
    return cars;
  }

  public ArrayList<RacingBoard> getRacingBoards() {
    return racingBoards;
  }
}
