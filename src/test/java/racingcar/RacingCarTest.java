package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {

    @Test
    public void validate_음수_입력값() {
        assertThatThrownBy(() -> RacingCar.validateInput(new int[] {-1, 3}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void random_범위() {
        int random = RacingCar.getRandomValue();
        assertThat(random)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

}
