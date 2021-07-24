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
    private final int ZERO = 0;

    public Race(int carCount, int roundCount) {
        validateInput(carCount, roundCount);
        lineUp(carCount);
        startRace(roundCount);
    }

    private void validateInput(int carCount, int roundCount) {
        if(isCarCountOverZero(carCount)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_CAR_COUNT_ERROR_MESSAGE);
        }
        if(isRoundCountOverZero(roundCount)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_ROUND_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isCarCountOverZero(int carCount) {
        return carCount < MIN_VALUE_BY_CAR;
    }

    private boolean isRoundCountOverZero(int roundCount) {
        return roundCount < MIN_VALUE_BY_CAR;
    }

    private void lineUp(int carCount) {
        this.rounds.add(new Round(
                Stream.generate(Car::new)
                        .limit(carCount)
                        .collect(toList())
        ));
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
