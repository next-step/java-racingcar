public class RacingCarGame {

  private final int chanceAmount;
  private final RacingCars racingCars;
  private final RacingCarGameResults racingCarGameResults;

  public RacingCarGame(int carAmount, int chanceAmount) {
    this.chanceAmount = chanceAmount;
    this.racingCars = new RacingCars(carAmount);
    this.racingCarGameResults = new RacingCarGameResults(carAmount);
  }

  public void play(MoveStrategy moveStrategy) {
    for (int i = 0; i < this.chanceAmount; i++) {
      racingCars.moveEachCars(moveStrategy);
      racingCarGameResults.addResult(racingCars);
    }
  }

  public RacingCarGameResults getResults() {
    return this.racingCarGameResults;
  }

}
