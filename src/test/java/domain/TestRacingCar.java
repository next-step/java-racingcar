package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCar {
    GoStraightBehavior goBehavior;
    GoStraightBehavior stopBehavior;

    @BeforeEach
    void setUp() {
        goBehavior = new GoStraightBehavior() {
            @Override
            public boolean isMoving() {
                return true;
            }
        };

        stopBehavior = new GoStraightBehavior() {
            @Override
            public boolean isMoving() {
                return false;
            }
        };
    }

    @Test
    void create_with_name() {
        RacingCar racingCar = new RacingCar("BMW");
        assertThat(racingCar).isEqualTo(new RacingCar("BMW"));
    }

    @Test
    void create_with_name_and_distance() {
        RacingCar racingCar = new RacingCar("BMW", 5);
        assertThat(racingCar).isEqualTo(new RacingCar("BMW", 5));
    }

    @Test
    void move() {
        RacingCar racingCar = new RacingCar("BMW", 0);
        racingCar.move(goBehavior);
        assertThat(racingCar).isEqualTo(new RacingCar("BMW", 1));
    }

    @Test
    void stop() {
        RacingCar racingCar = new RacingCar("BMW", 0);
        racingCar.move(stopBehavior);
        assertThat(racingCar).isEqualTo(new RacingCar("BMW", 0));
    }

    @Test
    void move_and_move() {
        RacingCar racingCar = new RacingCar("BMW", 0);
        racingCar.move(goBehavior);
        racingCar.move(goBehavior);
        assertThat(racingCar).isEqualTo(new RacingCar("BMW", 2));
    }
}
