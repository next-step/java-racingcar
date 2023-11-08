package ch3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    void 차는_위치를_가진다() {
        Car car = new Car();
        int result = car.getPosition();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 차는_4이상이면_전진한다() {
        Car car = new Car();
        car.move(4);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 차는_4미만이면_멈춘다() {
        Car car = new Car();
        car.move(2);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 차는_이름을_부여할_수_있다() {
        Car car = new Car();
        car.makeName("이창섭");
        assertThat(car.name()).isEqualTo("이창섭");
    }

}
