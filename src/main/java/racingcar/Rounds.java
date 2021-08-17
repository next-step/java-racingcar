package racingcar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rounds {
    private final Round[] rounds;
    private static final int MINIMUM_TRIAL_NUMBER = 1;
    private final int LAST_ROUND_INDEX;

    public Rounds(int roundNum) {
        isValidRoundNumber(roundNum);
        this.rounds = new Round[roundNum];
        LAST_ROUND_INDEX = this.rounds.length-1;
    }

    public void moveCarsForEachRound(Cars cars, MoveStrategy moveStrategy) {
        for (int i = 0; i < rounds.length; i++) {
            Round newRound = new Round(cars);
            cars = newRound.moveCars(moveStrategy);
            rounds[i] = newRound;
        }
    }

    private void isValidRoundNumber(int roundNum) {
        if (roundNum < MINIMUM_TRIAL_NUMBER) {
            throw new IllegalArgumentException("시도 회수는 "+MINIMUM_TRIAL_NUMBER+"이상의 정수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rounds rounds1 = (Rounds) o;
        return Arrays.equals(rounds, rounds1.rounds);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rounds);
    }

    List<List<Car>> getCarsStatusForEachRound() {
        List<List<Car>> result = new LinkedList<>();
        Arrays.stream(rounds).forEach(round -> result.add(round.getCarsStatusOfCurrentRound()));
        return result;
    }

    List<Car> getCarsStatusOfLastRound() {
        return rounds[LAST_ROUND_INDEX].getCarsStatusOfCurrentRound();
    }
}
