package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {

    @Test
    public void validate_음수_입력값() {
        assertThatThrownBy(() -> RacingGame.validateInput(new int[] {-1, 3}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void random_범위() {
        int random = RacingCar.getRandomValue();
        assertThat(random)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    public void 전진_여부() {
        RacingCar car = new RacingCar();
        car.moveOrStop(1);
        assertThat(car.getLocation())
                .isEqualTo(0);

        car.moveOrStop(4);
        assertThat(car.getLocation())
                .isEqualTo(1);
    }

}
