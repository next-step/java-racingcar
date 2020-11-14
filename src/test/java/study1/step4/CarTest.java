package study1.step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

public class CarTest {
    @Test
    void carCreateTest(){
        Car car = new Car("test racer", 1);
        assertThat(car).isEqualTo(new Car("test racer", 1));
    }

    @Test
    void carMoveTest(){
        Decision moveGenerator = new FixedMoveDecision(10);
        Car car = new Car("test racer", 1);

        car.move(moveGenerator);
        car.move(moveGenerator);
        car.move(moveGenerator);

        assertThat(car.isBestRacer(4)).isEqualTo(true);

        Decision notMoveGenerator = new FixedMoveDecision(1);

        car.move(notMoveGenerator);
        car.move(notMoveGenerator);
        car.move(notMoveGenerator);

        assertThat(car.isBestRacer(4)).isEqualTo(true);
    }
}
