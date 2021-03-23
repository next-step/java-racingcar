package racing.domain;

public class RacingRound {

  private final RacingCars racingCars;
  private Winners winners;
  private boolean finalRound;

  public RacingRound(RacingCars racingCars, boolean finalRound) {
    this(racingCars, Winners.create(racingCars), finalRound);
  }

  private RacingRound(RacingCars racingCars, Winners winners, boolean finalRound) {
    this.racingCars = RacingCars.copyFrom(racingCars);
    this.winners = winners;
    this.finalRound = finalRound;
  }

  public static RacingRound create(RacingCars racingCars) {
    return create(racingCars, false);
  }

  public static RacingRound create(RacingCars racingCars, boolean isFinalRound) {
    return new RacingRound(racingCars, isFinalRound);
  }

  public RacingCars racingCars() {
    return this.racingCars;
  }

  public Winners winners() {
    return winners;
  }

  public boolean isFinalRound() {
    return finalRound;
  }
}
