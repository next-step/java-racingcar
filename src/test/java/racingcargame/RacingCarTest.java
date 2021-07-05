package racingcargame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.model.MoveStrategy;
import racingcargame.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingCar racingCar;
    MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("yerim");
        moveStrategy = new MoveStrategy();
    }

    @DisplayName(value = "자동차는 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move(final int number) {
        racingCar.move(moveStrategy.isMovable(number));
        assertThat(racingCar.getStep()).isEqualTo(1);
    }

    @DisplayName(value = "자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(final int number) {
        racingCar.move(moveStrategy.isMovable(number));
        assertThat(racingCar.getStep()).isEqualTo(0);
    }

    @DisplayName(value = "자동차가 우승자이다.")
    @Test
    void is_winner() {
        assertThat(racingCar.isWinner(0)).isTrue();
    }
}
