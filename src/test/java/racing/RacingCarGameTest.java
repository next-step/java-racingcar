package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 자동차는_주어진_횟수만큼_이동한다() {
        CountingCar car = new CountingCar("june");
        car.move(() -> true);
        car.move(() -> false);
        assertThat(car.getMoveCount()).isEqualTo(2);
    }

}
