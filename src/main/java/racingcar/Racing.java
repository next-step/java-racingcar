package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.random.NumberGenerator;

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

  public RacingBoard racingRound(int round) {
    RacingBoard racingBoard = new RacingBoard(round);

    cars.forEach(car -> {
      if (isEnabledMove()) {
        car.move();
      }
      racingBoard.record(car.getPosition());
    });

    return racingBoard;
  }

  public List<RacingBoard> start() {
    return IntStream.range(0, round)
        .mapToObj(this::racingRound)
        .collect(Collectors.toCollection(() -> racingBoards));
  }

  public boolean isEnabledMove() {
    return numberGenerator.generateNumber() >= 4;
  }

  public ArrayList<Car> getCars() {
    return cars;
  }
}
