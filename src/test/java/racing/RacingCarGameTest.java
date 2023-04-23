package racing;

import org.junit.jupiter.api.Test;
import racing.domain.CountingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 각_자동차는_주어진_횟수만큼_이동한다() {
        CountingCar car = new CountingCar("june");
        car.move(3);
        car.move(7);
        assertThat(car.getMoveCount()).isEqualTo(2);
    }

}
