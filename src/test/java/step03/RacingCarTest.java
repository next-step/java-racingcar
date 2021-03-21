package step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setRacingCar() {
        racingCar = new RacingCar("test");
    }

    @Test
    @DisplayName("car tryToMove 무조건 전진 테스트")
    void tryToMove() {
        // when
        racingCar.tryToMove(() -> true);

        // then
        assertThat(racingCar.getRacingCarData().getMovingRange()).isEqualTo(1);
    }
}
