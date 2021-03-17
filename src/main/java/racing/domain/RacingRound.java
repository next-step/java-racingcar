package racing.domain;

public class RacingRound {

  private final RacingCars racingCars;

  private RacingRound(RacingCars racingCars) {
    this.racingCars = RacingCars.copyFrom(racingCars);
  }

  public static RacingRound create(RacingCars racingCars) {
    return new RacingRound(racingCars);
  }

  public RacingCars racingCars() {
    return this.racingCars;
  }

}
