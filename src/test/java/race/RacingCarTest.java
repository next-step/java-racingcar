package race;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = RacingCar.ready();
    }

    @DisplayName("forward 메소드 테스트")
    @Test
    public void forward() {
        assertThat(racingCar.forward()).isEqualTo(1);
    }

    @DisplayName("Stop 메소드 테스트")
    @Test
    public void stop() {
        assertThat(racingCar.stop()).isEqualTo(0);

        racingCar.forward();

        assertThat(racingCar.stop()).isEqualTo(1);
    }


}