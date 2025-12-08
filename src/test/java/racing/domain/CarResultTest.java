package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarResultTest {

    private final CarName carName = new CarName("자동차");

    @Test
    void 위치가_최대_위치와_같으면_true를_반환한다() {
        Car car = new Car(carName);
        car.move(() -> true);
        CarResult carResult = car.createCarResult();

        assertThat(carResult.isMaxPosition(new Position(1))).isTrue();
    }

    @Test
    void 위치가_최대_위치와_다르면_false를_반환한다() {
        Car car = new Car(carName);
        CarResult carResult = car.createCarResult();

        assertThat(carResult.isMaxPosition(new Position(1))).isFalse();
    }
}
