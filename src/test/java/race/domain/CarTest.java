package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 위치_받아오기() {
        int position = 0;
        assertThat(new Car(position).getPosition()).isEqualTo(position);
    }

    @Test
    void 전진() {
        Car car = new Car(0);
        assertThat(car.canForward(4)).isTrue();
    }

    @Test
    void 정지() {
        Car car = new Car(0);
        assertThat(car.canForward(3)).isFalse();
    }

    @Test
    void 이동() {
        Car car = new Car(0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
