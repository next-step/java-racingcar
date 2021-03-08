package RacingCarTest;

import RacingCar.RacingCar;
import RacingCar.MovementCondition;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    void Given_AlwaysMoveCondition_When_Racing_Then_DistanceIncreased() {
        MovementCondition movementCondition = new AlwaysMoveCondition();
        RacingCar racingCar = new RacingCar(movementCondition);
        int distance = racingCar.racing();
        assertThat(distance).isEqualTo(1);
    }

    @Test
    void Given_NoMoveCondition_When_Racing_Then_DistanceNotIncreased() {
        MovementCondition movementCondition = new NoMoveCondition();
        RacingCar racingCar = new RacingCar(movementCondition);
        int distance = racingCar.racing();
        assertThat(distance).isEqualTo(0);
    }
}
