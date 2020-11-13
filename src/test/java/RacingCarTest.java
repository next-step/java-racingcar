import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    public static RacingCarMovingRule regularRacingCarMovingRule() {
        return () -> true;
    }

    private static RacingCar racingCar;

    @BeforeAll
    static void initRacingCar() {
        racingCar = new RacingCar("testcar0", () -> true);
    }

    @Test
    void testRacingCarInitialPosition() {
        assertThat(racingCar.getPosition()).isEqualTo(RacingCar.INITIAL_POSITION);
    }

    @Test
    void testRacingCarMoving() {
        assertThat(racingCar.getPosition()).isEqualTo(RacingCar.INITIAL_POSITION);

        racingCar.forward();

        assertThat(racingCar.getPosition()).isEqualTo(RacingCar.INITIAL_POSITION + RacingCar.FORWARD_STEP);
    }

}
