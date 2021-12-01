package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.domain.PositionTest.p;

public class CarTest {
    @Test
    void maxPosition() {
        Car car = new Car("pobi", 10);
        assertThat(car.maxPosition(p(9))).isEqualTo(p(10));
        assertThat(car.maxPosition(p(11))).isEqualTo(p(11));
    }

    @Test
    void isWinner() {
        Car car = new Car("pobi", 10);
        assertThat(car.isWinner(p(10))).isTrue();
        assertThat(car.isWinner(p(9))).isFalse();
    }

    @Test
    public void 이동() {
        Car car = new Car("pobi");
        car.move(new RandomValue(4));
        assertThat(car.getPosition()).isEqualTo(p(1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi");
        car.move(new RandomValue(3));
        assertThat(car.getPosition()).isEqualTo(p(0));
    }
}
