public class RacingCarGame {

  private final int roundAmount;
  private final RacingCars racingCars;
  private final RacingCarGameResults racingCarGameResults;

  public RacingCarGame(String[] carNames, int roundAmount) {
    this.roundAmount = roundAmount;
    this.racingCars = new RacingCars(carNames);
    this.racingCarGameResults = new RacingCarGameResults(carNames.length);
  }

  public void play(MoveStrategy moveStrategy) {
    for (int round = 0; round < this.roundAmount; round++) {
      racingCars.moveEachCars(moveStrategy);
      racingCarGameResults.addResult(round, racingCars);
    }
    racingCarGameResults.setWinnerNames(racingCars);
  }

  public RacingCarGameResults getResults() {
    return this.racingCarGameResults;
  }

}
