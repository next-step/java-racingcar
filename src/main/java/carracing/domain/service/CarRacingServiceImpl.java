package carracing.domain.service;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundData;
import carracing.domain.dto.RoundResult;
import carracing.domain.entity.Car;
import carracing.domain.entity.Cars;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarRacingServiceImpl implements CarRacingService{

  private static final String GAME_START_ERROR_MESSAGE = "게임을 시작할 수 없습니다.";

  private MoveStrategy moveStrategy;

  public CarRacingServiceImpl(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  @Override
  public Cars registerRacer(Participant participant) {
    Cars cars = new Cars();
    for (int id = 0; id < participant.size(); id++) {
      cars.register(new Car(participant.getParticipant().get(id)));
    }
    return cars;
  }

  @Override
  public RacingResult gameStart(Round round, Cars cars) {
    validateInputValue(round, cars);

    List<RoundData> roundDataList = new ArrayList<>();
    while (round.hasMoreChance()) {
      roundDataList.add(startRound(cars));
      round.minus();
    }
    return new RacingResult(new RoundResult(roundDataList), cars.getWinner());
  }

  private void validateInputValue(Round round, Cars cars) {
    if (round == null || cars == null) {
      throw new IllegalArgumentException(GAME_START_ERROR_MESSAGE);
    }
  }

  private RoundData startRound(Cars cars) {
    cars.notifyCarOfStart(moveStrategy.isMovable());
    return getRacingData(cars);
  }

  private RoundData getRacingData(Cars cars) {
    return cars.getCarList().stream()
                      .map(car -> new RacingData(car.getName(), car.getNowStep()))
                      .collect(collectingAndThen(toList(), RoundData::new));
  }

}
