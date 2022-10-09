package step3_pobi.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 최대값_구하기() {
        Car car = new Car("pobi", 3);
        assertThat(car.maxPosition(4)).isEqualTo(4);
        assertThat(car.maxPosition(2)).isEqualTo(3);
    }

    @Test
    void 최대값_일치() {
        Car car = new Car("pobi", 3);
        assertThat(car.isMaxPosition(3)).isTrue();
        assertThat(car.isMaxPosition(2)).isFalse();
    }

    @Test
    void 이동() {
        Car car = new Car("pobi");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}