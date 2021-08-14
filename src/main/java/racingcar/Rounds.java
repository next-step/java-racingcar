package racingcar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rounds {
    private final Round[] rounds;

    public Rounds(int roundNum) {
        isValidRoundNumber(roundNum);
        this.rounds = new Round[roundNum];
    }

    public void moveCarsForEachRound(Cars cars, MoveStrategy moveStrategy) {
        for (int i = 0; i < rounds.length; i++) {
            Round newRound = new Round(cars);
            cars = newRound.moveCars(moveStrategy);
            rounds[i] = newRound;
        }
    }

    private void isValidRoundNumber(int roundNum) {
        if (roundNum <= 0) {
            throw new IllegalArgumentException("시도 회수는 1이상의 정수입니다.");
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
}
