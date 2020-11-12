package step3.domain;

import step3.domain.strategy.Movable;
import step3.domain.strategy.MoveStrategy;
import step3.util.Validator;

import java.util.*;

/**
 * Created By mand2 on 2020-11-04.
 * 경주 operation
 */
public class Racing {

    private final int rounds;
    private final Cars cars;
    private List<ScoreBoard> scoreBoards;
    private MoveStrategy moveStrategy;

    private Racing(String carNames, int rounds, MoveStrategy moveStrategy) {
        this.rounds = rounds;
        this.cars = Cars.of(carNames);
        this.scoreBoards = new ArrayList<>();
        this.moveStrategy = moveStrategy;
    }

    public static Racing of(String carNames, int rounds, MoveStrategy moveStrategy) {
        Validator.checkArgumentInRange(rounds, 1);

        return new Racing(carNames, rounds, moveStrategy);
    }

    public void race() {
        for (int i = rounds; i > 0; i--) {
            this.cars.runRound(this.moveStrategy);
            this.scoreBoards = this.cars.getRoundScore();
        }
    }

    public List<ScoreBoard> getScoreBoard() {
        return this.scoreBoards;
    }

    public String getWinner() {
        return this.cars.getWinners();
    }

    public int getRounds() {
        return rounds;
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
