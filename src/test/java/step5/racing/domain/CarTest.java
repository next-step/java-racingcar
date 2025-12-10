package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차를_생성하면_이름이_저장되고_위치가_0으로_설정된다() {
        Car car = new Car("자동차");

        assertThat(car.position()).isEqualTo(new Position(0));
        assertThat(car.name().value()).isEqualTo("자동차");
    }
}
