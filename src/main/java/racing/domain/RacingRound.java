package racing.domain;

public class RacingRound {

  private final RacingCars racingCars;
  private Winners winners;
  private int remainingRounds;

  private RacingRound(RacingCars racingCars, int remainingRounds) {
    this(RacingCars.copyFrom(racingCars), Winners.create(racingCars), remainingRounds);
  }

  private RacingRound(RacingCars racingCars, Winners winners, int remainingRounds) {
    this.racingCars = racingCars;
    this.winners = winners;
    this.remainingRounds = remainingRounds;
  }

  public static RacingRound createFinalRound(RacingCars racingCars) {
    return create(racingCars, 0);
  }

  public static RacingRound create(RacingCars racingCars, int remainingRounds) {
    return new RacingRound(racingCars, remainingRounds);
  }

  public RacingCars racingCars() {
    return this.racingCars;
  }

  public Winners winners() {
    return winners;
  }

  public boolean isFinalRound() {
    return remainingRounds == 0;
  }


}
