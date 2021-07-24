package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;
import racingCar.domain.strategy.RacingMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Race {

    private static final List<Round> rounds = new ArrayList<>();
    private MoveStrategy moveStrategy = new RacingMoveStrategy();
    private final int MIN_VALUE_BY_CAR = 1;
    private final static String IS_NOT_DUAL_CAR_COUNT_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";
    private final static String IS_NOT_DUAL_ROUND_COUNT_ERROR_MESSAGE = "라운드는 1라운드 이상이어야 합니다.";
    private final String COMMA = ",";
    private final int ZERO = 0;

    public Race(String names, int roundCount) {
        validateInput(names, roundCount);
        lineUp(names);
        startRace(roundCount);
    }

    private void validateInput(String names, int roundCount) {
        if(isCarCountOverZero(names)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_CAR_COUNT_ERROR_MESSAGE);
        }
        if(isRoundCountOverZero(roundCount)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_ROUND_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isCarCountOverZero(String names) {
        return names.split(COMMA).length < MIN_VALUE_BY_CAR;
    }

    private boolean isRoundCountOverZero(int roundCount) {
        return roundCount < MIN_VALUE_BY_CAR;
    }

    private void lineUp(String names) {
        List<Car> cars = new ArrayList();
        String[] strings = names.split(COMMA);

        for(String name : strings) {
            cars.add(new Car(new Name(name)));
        }

        this.rounds.add(new Round(cars));
    }

    private void startRace(int roundCount) {
        int roundNumber = ZERO;
        while (roundNumber < roundCount){
            Round round = rounds.get(roundNumber).startRound(moveStrategy);
            this.rounds.add(round);
            roundNumber++;
        }
    }

    public Round getRoundResult(int roundNumber) {
        return rounds.get(roundNumber);
    }

    public int getRoundCount() {
        return rounds.size();
    }

}
