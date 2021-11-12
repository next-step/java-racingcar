package carracing.domain.service;

import carracing.domain.entity.Car;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Number;
import carracing.domain.entity.Round;

public class FourStandardCarRacingService implements CarRacingService{

  private static final int STEP_FORWARD_STANDARD = 4;

  private Challengers challengers;
  private Round round;

  public FourStandardCarRacingService(Number number, Round round) {
    if (!isValidInput(number, round)) {
      throw new IllegalArgumentException();
    }
    this.challengers = new Challengers(number);
    this.round = round;
    initRacing(number, round);
  }

  private boolean isValidInput(Number number, Round round) {
    return number != null && round != null;
  }

  @Override
  public void initRacing(Number number, Round round) {
    for (int i = 0; i < number.getValue(); i++) {
      challengers.register(new Car(round));
    }
  }

  @Override
  public String gameStart() {
    StringBuilder sb = new StringBuilder();
    while (round.hasMoreChance()) {
      sb.append(challengers.startRound(STEP_FORWARD_STANDARD));
      sb.append(System.lineSeparator());
      round.minus();
    }
    return sb.toString();
  }

  public Challengers getChallengers() {
    return challengers;
  }
}
