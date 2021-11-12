package carracing.domain.service;

import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundResult;
import carracing.domain.entity.Car;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Number;
import carracing.domain.entity.Round;
import carracing.domain.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RandomFourStepRacingService implements CarRacingService{

  private static final int STEP_FORWARD_STANDARD = 4;

  private Challengers challengers;
  private Round round;

  public RandomFourStepRacingService(Number number, Round round) {
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
      challengers.register(new Car());
    }
  }

  @Override
  public RacingResult gameStart() {
    List<RoundResult> roundResultList = new ArrayList<>();
    while (round.hasMoreChance()) {
      roundResultList.add(challengers.startRound(isMoved()));
      round.minus();
    }
    return new RacingResult(roundResultList);
  }

  @Override
  public Supplier<Boolean> isMoved() {
    return () -> RandomUtils.isGreaterThanOrEquals(STEP_FORWARD_STANDARD);
  }

  public Challengers getChallengers() {
    return challengers;
  }
}
