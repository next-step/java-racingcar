package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private final CarName carName = new CarName("자동차");

    @Test
    void 자동차를_생성하면_첫_위치가_0이_된다() {
        Car car = new Car(carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동_전략이_false이면_전진하지_않는다() {
        Car car = new Car(carName);
        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동_전략이_true이면_전진한다() {
        Car car = new Car(carName);
        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_현재_상태의_CarResult를_생성한다() {
        Car car = new Car(carName);
        CarResult carResult = car.createCarResult();

        assertThat(carResult.getCarName().value()).isEqualTo("자동차");
        assertThat(carResult.getPosition().value()).isEqualTo(0);
    }

    @Test
    void 자동차가_최대_위치와_같으면_true를_반환한다() {
        Car car = new Car(carName);
        car.move(() -> true);

        assertThat(car.maxPosition(new Position(1))).isTrue();
    }

    @Test
    void 자동차가_최대_위치와_다르면_false를_반환한다() {
        Car car = new Car(carName);

        assertThat(car.maxPosition(new Position(1))).isFalse();
    }
}
