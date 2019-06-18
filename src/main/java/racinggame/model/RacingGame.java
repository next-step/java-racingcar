package racinggame.model;

public class RacingGame {
  private Cars cars;

  public RacingGame(int carCount) {
    cars = new Cars(carCount);
  }

  public Cars startGame() {
    return cars.moveCars();
  }
}
