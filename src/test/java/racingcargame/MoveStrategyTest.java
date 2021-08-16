package racingcargame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.model.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {
    MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new MoveStrategy();
    }

    @DisplayName(value = "자동차는 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move(final int number) {
        assertThat(moveStrategy.isMovable(number)).isTrue();
    }

    @DisplayName(value = "자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(final int number) {
        assertThat(moveStrategy.isMovable(number)).isFalse();
    }
}