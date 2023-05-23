package study.step4.domain;

import org.junit.jupiter.api.Test;
import study.step4.move.AlwaysMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void carMoveTest() {
        Car car = new Car("test");
        for (int i = 0; i < 5; i++) {
            car.move(new AlwaysMoveStrategy());
        }
        assertThat(car.getPosition()).isEqualTo(6);
    }

}