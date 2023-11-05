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


}
