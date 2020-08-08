package racing.strategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.AboveNumberMove;

import static org.assertj.core.api.Assertions.assertThat;

public class MovableStrategy {

    @ParameterizedTest
    @CsvSource({"2, false", "3, false", "4, true", "5, true"})
    void move(int number, boolean expect) {
        AboveNumberMove movableStrategy = new AboveNumberMove(4, () -> number);

        boolean move = movableStrategy.move();

        assertThat(move).isEqualTo(expect);
    }
}
