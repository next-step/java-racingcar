package racing_refactoring.domain;

import racing_refactoring.strategy.CarStrategyImpl;
import racing_refactoring.strategy.CarStrategy;
import racing_refactoring.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;

public final class Participants {
    private final static CarStrategy CAR_STRATEGY = new CarStrategyImpl();
    private final static String NAME_SEPARATOR = ",";

    private List<Car> carList;

    public Participants(final String carNames) {
        if(CAR_STRATEGY.underMinLength(carNames)){
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
        this.carList = setParticipants(carNames);
    }

    public RacingResult race(final RacingStrategy racingStrategy){
        List<Car> racingResult = new ArrayList<>();
        for(Car car : carList){
            racingResult.add(car.move(racingStrategy));
        }
        return new RacingResult(racingResult);
    }

    private List<Car> setParticipants(final String carNames) {
        List<Car> participants = new ArrayList<>();

        for(String names : splitParticipant(carNames)){
            participants.add(new Car(names));
        }

        return participants;
    }

    private String[] splitParticipant(final String carNames){
        return carNames.split(NAME_SEPARATOR);
    }
}
