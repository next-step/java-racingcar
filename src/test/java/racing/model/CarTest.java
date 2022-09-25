package racing.model;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 전진조건은_랜덤값_4이상일_경우() {
        Car car = new Car();
        assertThat(car.canMove(4)).isTrue();
        assertThat(car.canMove(5)).isTrue();
        assertThat(car.canMove(3)).isFalse();
    }

    @Test
    void 자동차는_최초에_위치가_1이여야한다() {
        assertThat(new Car(1)).isEqualTo(new Car());
    }

    @Test
    void 자동차가_한번_움직이면_위치가_2가되어야한다() {
        Car car = new Car();
        car.move();
        assertThat(car).isEqualTo(new Car(2));
    }

    @Test
    void 자동차_현재위치_출력() {
        assertThat(new Car().printPosition()).isEqualTo("-");
    }
}
