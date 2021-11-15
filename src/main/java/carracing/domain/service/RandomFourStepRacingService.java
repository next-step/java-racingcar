package carracing.domain.service;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundData;
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

import static java.util.stream.Collectors.toList;

public class RandomFourStepRacingService implements CarRacingService{

  private static final int STEP_FORWARD_STANDARD = 4;
  private static final String GAME_START_ERROR_MESSAGE = "게임을 시작할 수 없습니다.";

  @Override
  public Challengers registerRacer(Participant participant) {
    Challengers challengers = new Challengers(participant);
    for (int id = 0; id < participant.size(); id++) {
      challengers.register(new Car(participant.getParticipant().get(id)));
    }
    return challengers;
  }

  @Override
  public RacingResult gameStart(Round round, Challengers challengers) {
    validateInputValue(round, challengers);
    List<RoundData> roundDataList = new ArrayList<>();
    while (round.hasMoreChance()) {
      roundDataList.add(startRound(challengers));
      round.minus();
    }
    return new RacingResult(new RoundResult(roundDataList), Winner.pickWinner(challengers.getChallengers()));
  }

  private void validateInputValue(Round round, Challengers challengers) {
    if (round == null || challengers == null) {
      throw new IllegalArgumentException(GAME_START_ERROR_MESSAGE);
    }
  }

  public BooleanSupplier isMovable() {
    return () -> RandomUtils.isGreaterThanOrEquals(STEP_FORWARD_STANDARD);
  }

  private RoundData startRound(Challengers challengers) {
    challengers.notifyCarOfStart(isMovable());
    List<RacingData> racingDataList = challengers.getChallengers().stream()
                                                                  .map(car -> new RacingData(car.getName(), car.getNowStep()))
                                                                  .collect(toList());
    return new RoundData(racingDataList);
  }

}
