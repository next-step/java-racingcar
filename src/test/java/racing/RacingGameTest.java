package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("4 이상의 숫자가 나왔을 때 움직이는지 확인합니다")
    public void moveTest() {
        RacingCars racingCars = new RacingCars(3);
        racingCars.race(new FixedRoulette(4));
        assertThat(racingCars.getCars())
                .extracting(Car::getDisplacement)
                .allMatch(displacement -> displacement == 1);
    }

    @Test
    @DisplayName("4 미만의 숫자가 나왔을 때 안 움직이는지 확인합니다")
    public void doNotMoveTest() {
        RacingCars racingCars = new RacingCars(3);
        racingCars.race(new FixedRoulette(0));
        assertThat(racingCars.getCars())
                .extracting(Car::getDisplacement)
                .allMatch(displacement -> displacement == 0);
    }
}
