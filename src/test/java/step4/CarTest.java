package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차는_조건이_참이면_전진한다() {
        Car car = new Car("");

        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void 자동차는_조건이_거짓이면_전진하지_않는다() {
        Car car = new Car("");

        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차의_상태는_이름과_진행한_거리를_반환한다() {
        String name = "myCar";
        Car car = new Car(name);

        car.move(() -> true);

        assertThat(car.getCurrentStatus()).isEqualTo("myCar : -");
    }

}