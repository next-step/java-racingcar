package step4;

import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.Moving;
import step4.domain.RandomMoving;
import step4.view.result.CarMovementResult;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void move() {
        final Car car = Car.withName("test");
        final Moving strategy = new RandomMoving() {
            @Override
            public boolean movable() {
                return true;
            }
        };

        car.move(strategy);

        final CarMovementResult result = car.movementResult();
        assertThat(result.moveCount()).isEqualTo(1);
    }

}
