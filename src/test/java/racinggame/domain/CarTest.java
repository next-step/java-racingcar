package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void maxPosition() {
        Car car = new Car("pobi", 10);
        assertThat(car.maxPosition(9)).isEqualTo(10);
        assertThat(car.maxPosition(11)).isEqualTo(11);
    }

    @Test
    void isWinner() {
        Car car = new Car("pobi", 10);
        assertThat(car.isWinner(10)).isTrue();
        assertThat(car.isWinner(9)).isFalse();
    }

    @Test
    public void 이동() {
        Car car = new Car("pobi");
        assertThat(car.movedCar(new RandomValue(4))).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi");
        assertThat(car.movedCar(new RandomValue(3))).isEqualTo(new Car("pobi", 0));
    }
}
