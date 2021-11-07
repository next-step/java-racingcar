public class RacingCarGame {

  private int chanceAmount;
  private RacingCars racingCars;
  private RacingCarGameResults racingCarGameResults;

  public RacingCarGame(int carAmount, int chanceAmount) {
    this.chanceAmount = chanceAmount;
    this.racingCars = new RacingCars(carAmount);
    this.racingCarGameResults = new RacingCarGameResults(carAmount);
  }

  public void play() {
    for (int i = 0; i < this.chanceAmount; i++) {
      racingCars.moveEachCars(new RandomMoveStrategy());
      racingCarGameResults.addResult(racingCars);
    }
  }

  public RacingCarGameResults getResults() {
    return this.racingCarGameResults;
  }

}
