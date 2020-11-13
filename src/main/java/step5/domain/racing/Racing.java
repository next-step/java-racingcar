package step5.domain.racing;

import step5.domain.InputValue;
import step5.domain.racing.cars.ScoreBoard;
import step5.domain.strategy.MoveStrategy;
import step5.util.Validator;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-11-04.
 * 경주 operation
 */
public class Racing {

    private final Round rounds;
    private final Cars cars;
    private MoveStrategy moveStrategy;

    private Racing(InputValue inputValue, MoveStrategy moveStrategy) {
        this.rounds = Round.of(inputValue.getRounds());
        this.cars = Cars.of(inputValue.getCarNames());
        this.moveStrategy = moveStrategy;
    }

    public static Racing of(InputValue inputValue, MoveStrategy moveStrategy) {
        Validator.checkArgumentInRange(inputValue.getRounds(), 1);

        return new Racing(inputValue, moveStrategy);
    }

    public void race() {
        for (int i = rounds.round(); i > 0; i--) {
            this.cars.runRound(this.moveStrategy);
        }
    }

    public List<ScoreBoard> getScoreBoard() {
        return this.cars.getScoreBoards();
    }

    public String getWinner() {
        return this.cars.getWinners();
    }

    public int getRounds() {
        return rounds.round();
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
