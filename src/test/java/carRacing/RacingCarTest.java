package carRacing;

import carRacing.model.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RacingCarTest {

    private RacingCar racingCar;
    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    void moveCar() {
        racingCar.move(() -> true);
        assertThat(racingCar.positionOfRacingCar()).isEqualTo(1);
    }

    @Test
    void stopCar() {
        racingCar.move(() -> false);
        assertThat(racingCar.positionOfRacingCar()).isEqualTo(0);
    }
}
