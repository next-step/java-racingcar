package racingCar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.game.generator.IntGenerator;
import racingCar.game.generator.RandomGenerator;

public class RacingCarGame {

  private final RacingCars cars;

  public RacingCarGame(List<String> carNames) {
    int randomUpperBound = 10;
    IntGenerator intGenerator = new RandomGenerator(randomUpperBound);
    List<Car> racingCars = carNames.stream().map(carName -> new Car(carName, intGenerator)).collect(Collectors.toList());
    this.cars = new RacingCars(racingCars);
  }

  public GameResult playGames(int round) {
    List<String> resultsPerRound = new ArrayList<>();
    for (int i = 0; i < round; i++) {
      playGame();
      resultsPerRound.add(getGameResult());
    }
    return new GameResult(findWinners(), resultsPerRound);
  }

  private void playGame() {
    cars.move();
  }

  private String getGameResult() {
    return cars.getMovedPath();
  }

  private List<String> findWinners() {
    return cars.findWinners();
  }

}