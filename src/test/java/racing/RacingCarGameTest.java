package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 자동차는_주어진_횟수만큼_이동한다() {
        Car car = new Car("june");
        car.move(() -> true);
        car.move(() -> false);
        assertThat(car.position()).isEqualTo(new Position(1));
    }

}
