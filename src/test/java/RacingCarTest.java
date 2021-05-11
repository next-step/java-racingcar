import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName(value = "무작위값이 4 이상일 경우 자동차는 전진한다.")
    @Test
    void should_move_When_randomNumber_is_equal_or_greater_than_4() {
        RacingCar racingCar = new RacingCar("pobi,woni,jun");
        racingCar.move(4);
        assertThat(racingCar.getStep()).isEqualTo(1);
    }

    @DisplayName(value = "무작위값이 4 미만일 경우 자동차는 전진하지 않는다.")
    @Test
    void should_not_move_When_randomNumber_is_less_than_4() {
        RacingCar racingCar = new RacingCar("pobi,woni,jun");
        racingCar.move(3);
        assertThat(racingCar.getStep()).isEqualTo(0);
    }
}
