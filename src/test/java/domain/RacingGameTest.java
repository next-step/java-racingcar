package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.MovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    public void setup() {
        cars = new Cars(Arrays.asList(new Car("kks"),
                new Car("kjm"),
                new Car("bjs"),
                new Car("honux")));
        racingGame = new RacingGame();
    }

    @Test
    public void playGameWithFalseMovableStrategyGameCarsDoesNotMoveTest() {
        MovableStrategy falseMovableStrategy = () -> false;

        racingGame.playGame(cars, falseMovableStrategy);

        assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("kks", new Location()),
                new Car("kjm", new Location()),
                new Car("bjs", new Location()),
                new Car("honux", new Location()))));
    }

    @Test
    public void playGameWithTrueMovableStrategyGameCarsMoveTest() {
        MovableStrategy trueMovableStrategy = () -> true;

        racingGame.playGame(cars, trueMovableStrategy);

        assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("kks", new Location(1)),
                new Car("kjm", new Location(1)),
                new Car("bjs", new Location(1)),
                new Car("honux", new Location(1)))));
    }

}
