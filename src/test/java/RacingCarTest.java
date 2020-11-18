import domain.RacingCar;
import domain.RacingCarMovingRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarTest {

    public static RacingCarMovingRule regularRacingCarMovingRule() {
        return () -> true;
    }

    private static RacingCar racingCar;

    @BeforeAll
    static void initRacingCar() {
        racingCar = new RacingCar("car0", () -> true);
    }

    @ParameterizedTest
    @CsvSource(value = {"1234,true", "123456,false"})
    void testRacingCarNameLength(String carName, boolean expectValidLength) {
        if (expectValidLength) {
            assertThat(carName.length()).isLessThanOrEqualTo(RacingCar.MAX_NAME_LENGTH);

            new RacingCar(carName, () -> true);
        } else {
            assertThat(carName.length()).isGreaterThan(RacingCar.MAX_NAME_LENGTH);

            assertThatIllegalArgumentException().isThrownBy(() -> {
                new RacingCar(carName, () -> true);
            });
        }
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
