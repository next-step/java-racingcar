package racingCar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.game.generator.IntGenerator;
import racingCar.game.generator.RandomGenerator;

public class RacingCarGame {

  private final List<Car> cars;

  public RacingCarGame() {
    this.cars = new ArrayList<>();
  }

  public void initiateGame(List<String> carNames) {
    IntGenerator intGenerator = new RandomGenerator();
    for (String carName : carNames) {
      cars.add(new Car(carName, intGenerator));
    }
  }

  public GameResult playGames(int round) {
    GameResult gameResult = new GameResult();
    for (int i = 0; i < round; i++) {
      playGame();
      gameResult.addRoundResult(getGameResult());
    }
    gameResult.setWinners(findWinners());
    return gameResult;
  }

  private void playGame() {
    for (Car car : cars) {
      car.move();
    }
  }

  private String getGameResult() {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars) {
      sb.append(car.getName()).append(" : ").append(car.getMovedPath()).append("\n");
    }
    return sb.toString();
  }

  private List<String> findWinners() {
    cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
    int maxPosition = cars.get(0).getPosition();
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName).collect(Collectors.toList());
  }

}