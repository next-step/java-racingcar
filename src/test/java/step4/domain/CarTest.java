package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car("testCar");

    @Test
    void 자동차는_이름으로_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 생성된_자동차의_최초위치는_0이다() {
        assertThat(car.getPosition()).isEqualTo(Position.ZERO);
    }

    @Test
    void 자동차가_전진하면_position이_1만큼_증가한다() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
