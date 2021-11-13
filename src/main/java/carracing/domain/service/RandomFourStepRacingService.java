package carracing.domain.service;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundResult;
import carracing.domain.entity.Car;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;
import carracing.domain.entity.Winner;
import carracing.domain.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class RandomFourStepRacingService implements CarRacingService{

  private static final int STEP_FORWARD_STANDARD = 4;

  private Challengers challengers;
  private Round round;

  public RandomFourStepRacingService(Participant participant, Round round) {
    if (!isValidInput(participant, round)) {
      throw new IllegalArgumentException();
    }
    this.challengers = new Challengers(participant);
    this.round = round;
    initRacing(participant);
  }

  private boolean isValidInput(Participant member, Round round) {
    return member != null && member.getParticipant().size() > 0 && round != null;
  }

  @Override
  public void initRacing(Participant participant) {
    for (int id = 0; id < participant.getParticipant().size(); id++) {
      challengers.register(new Car(participant.getParticipant().get(id)));
    }
  }

  @Override
  public RacingResult gameStart() {
    List<RoundResult> roundResultList = new ArrayList<>();
    while (round.hasMoreChance()) {
      roundResultList.add(RoundResult.of(RacingData.of(challengers.startRound(isMovable()))));
      round.minus();
    }
    return new RacingResult(roundResultList, Winner.pickWinner(challengers.getChallengers()));
  }

  public BooleanSupplier isMovable() {
    return () -> RandomUtils.isGreaterThanOrEquals(STEP_FORWARD_STANDARD);
  }

  public Challengers getChallengers() {
    return challengers;
  }
}
