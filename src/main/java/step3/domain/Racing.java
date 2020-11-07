package step3.domain;

import step3.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-11-04.
 * 경주 operation
 */
public class Racing {

    private final int rounds;
    private final Cars cars;
    private List<Integer> scoreBoard;

    private Racing(int participants, int rounds) {
        this.rounds = rounds;
        this.cars = new Cars(participants);
        this.scoreBoard = new ArrayList<>();
    }

    public static Racing of(int participants, int rounds) {
        Validator.checkArgumentInRange(participants, 1);
        Validator.checkArgumentInRange(rounds, 1);

        return new Racing(participants, rounds);
    }

    public void race() {
        for (int i = rounds; i > 0; i--) {
            this.cars.runRound();
            this.scoreBoard.addAll(cars.getRoundScore());
        }
    }

    public List<Integer> getScoreBoard() {
        return this.scoreBoard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rounds, cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return Objects.equals(rounds, racing.rounds)
                && Objects.equals(cars, racing.cars);
    }
}
