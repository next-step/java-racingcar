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

    @Test
    void 이동전략이_true일_때_자동차가_이동한다() {
        Car car = new Car("자동차");
        car.move(() -> true);

        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @Test
    void 이동전략이_false일_때_자동차가_이동하지_않는다() {
        Car car = new Car("자동차");
        car.move(() -> false);

        assertThat(car.position()).isEqualTo(new Position(0));
    }

    @Test
    void 자동차의_결과를_생성한다() {
        Car car = new Car("자동차");
        car.move(() -> true);

        CarResult carResult = car.createResult();

        assertThat(carResult.name().value()).isEqualTo("자동차");
        assertThat(carResult.position()).isEqualTo(new Position(1));
    }
}
