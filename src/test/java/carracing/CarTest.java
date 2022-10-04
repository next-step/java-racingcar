package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 이동() {
        Car car = new Car("A");
        assertThat(car.move(() -> true)).isEqualTo(new Car("A", 1));
    }

    @Test
    void 정지() {
        Car car = new Car("A");
        assertThat(car.move(() -> false)).isEqualTo(new Car("A", 0));
    }

    @Test
    void 차위치_비교() {
        Car carA = new Car("A", 0);
        Car carB = new Car("B", 1);

        assertThat(carA.isFartherThan(carB)).isFalse();
    }
}
