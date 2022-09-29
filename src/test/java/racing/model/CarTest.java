package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 기본_자동차의_전진조건은_랜덤값_4이상일_경우() {
        Car car = new DefaultCar("test");
        assertThat(car.canMove(4)).isTrue();
        assertThat(car.canMove(5)).isTrue();
        assertThat(car.canMove(3)).isFalse();
    }

    @Test
    void 자동차는_최초에_위치가_1이여야한다() {
        assertThat(new DefaultCar("test", new CarPosition(1))).isEqualTo(new DefaultCar("test"));
    }

    @Test
    void 기본_자동차가_한번_움직이면_위치가_2가되어야한다() {
        Car car = new DefaultCar("test");
        car.move();
        assertThat(car).isEqualTo(new DefaultCar("test", new CarPosition(2)));
    }

    @Test
    void 자동차에_이름을_부여된다() {
        Car car = new DefaultCar("a");
        assertThat(car.getName()).isEqualTo("a");
    }
}
