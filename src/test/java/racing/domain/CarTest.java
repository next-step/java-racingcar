package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차를_생성하면_첫_위치가_0이_된다() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
