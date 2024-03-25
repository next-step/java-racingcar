package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        Car car = new Car();

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car();

        car.move(3);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 우승자_찾기() {
        
    }
}
