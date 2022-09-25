package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void tryMove_직진한다() {
        Car car = new Car(1);

        car.tryMove(1);
        Assertions.assertThat(car.getStraightCount()).isEqualTo(0);

        car.tryMove(9);
        Assertions.assertThat(car.getStraightCount()).isEqualTo(1);
    }

}
