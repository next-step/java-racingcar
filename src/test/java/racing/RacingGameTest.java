package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import racing.domain.Car;
import racing.domain.FixedRoulette;
import racing.domain.RacingCars;

public class RacingGameTest {

    @Test
    @DisplayName("항상 움직이는지 확인합니다")
    public void moveTest() {
        RacingCars racingCars = new RacingCars(3);
        racingCars.race(new FixedRoulette(4));
        assertThat(racingCars.getCars())
                .extracting(Car::getDisplacement)
                .allMatch(displacement -> displacement == 1);
    }

    @Test
    @DisplayName("항상 안 움직이는지 확인합니다")
    public void doNotMoveTest() {
        RacingCars racingCars = new RacingCars(3);
        racingCars.race(new FixedRoulette(0));
        assertThat(racingCars.getCars())
                .extracting(Car::getDisplacement)
                .allMatch(displacement -> displacement == 0);
    }
}
