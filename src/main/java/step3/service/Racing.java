package step3.service;

import step3.domain.Cars;
import step3.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-11-04.
 * 경주 operation
 */
public class Racing {

    private final int rounds;
    private final Cars cars;
    private List<Integer> scoreBoard;

    private Racing(String carNames, int rounds) {
        this.rounds = rounds;
        this.cars = Cars.of(carNames);
        this.scoreBoard = new ArrayList<>();
    }

    public static Racing of(String carNames, int rounds) {
        Validator.checkEmpty(carNames);
        Validator.checkArgumentInRange(rounds, 1);

        return new Racing(carNames, rounds);
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

    public int getParticipantsNum() {
        return this.cars.carNum();
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
