package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import step1.racing.data.RacingCar;

class RacingGameTest {
    private Moveable moveable = new Moveable() {
        @Override
        public boolean isMoveable() {
            return true;
        }
    };

    @Test
    void throw_exception_if_empty_args() {
        assertThatThrownBy(() -> new RacingGame(Collections.EMPTY_LIST, moveable, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_only_winner() {
        RacingCar c1 = new RacingCar("c1", 3);
        RacingCar c2 = new RacingCar("c2", 2);

        RacingGame sut = new RacingGame(Arrays.asList(c1, c2), moveable, 1);

        assertThat(sut.getWinners()).contains(c1);
    }

    @Test
    void check_car_position_moved_when_race() {
        RacingCar c1 = new RacingCar("c1", 1);
        RacingGame sut = new RacingGame(Arrays.asList(c1), moveable, 1);

        sut.move();

        assertThat(c1.getPosition()).isEqualTo(2);
    }
}
