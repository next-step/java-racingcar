package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.generator.IntGenerator;
import racingCar.domain.generator.RandomGenerator;

public class RacingCarGame {

  IntGenerator intGenerator;
  private final RacingCars cars;

  public RacingCarGame(List<String> carNames) {
    int randomUpperBound = 10;
    intGenerator = new RandomGenerator(randomUpperBound);
    List<Car> racingCars = carNames.stream().map(Car::new).collect(Collectors.toList());
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
    cars.move(decideMovingCars());
  }

  private List<Boolean> decideMovingCars() {
    List<Boolean> isMovingCars = new ArrayList<>();
    for(int i = 0 ; i < cars.getCarCount() ; i  ++){
      isMovingCars.add(isMovingCar());
    }
    return isMovingCars;
  }

  private boolean isMovingCar() {
    int randomNumber = intGenerator.nextInt();
    if (randomNumber >= 4) {
      return true;
    }
    return false;
  }

  private String getGameResult() {
    return cars.getMovedPath();
  }

  private List<String> findWinners() {
    return cars.findWinners();
  }

}