package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Rounds {
    private Round[] rounds;

    public Rounds(int totalRoundNum) {
        this.rounds = new Round[totalRoundNum];
    }

    /* 테스트를 위한 생성자 */
    public Rounds(Round[] rounds) {
        this.rounds = rounds;
    }

    public void moveCarsForEachRound(Cars cars, MoveRule moveRule) {
        for (int i = 0; i < rounds.length; i++) {
            Round newRound = new Round(cars);
            cars = newRound.moveCars(moveRule);
            rounds[i] = newRound;
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
}
