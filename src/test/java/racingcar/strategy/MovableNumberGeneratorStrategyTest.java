package racingcar.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

@DisplayName("전진 전략 테스트")
class MovableNumberGeneratorStrategyTest {

    @DisplayName("전진 전략은 차가 이동한다")
    @Test
    void 전진하는_조건_테스트() {
        Car car = new Car("korea");

        car.move(new MovableNumberGeneratorStrategy());
        int point = car.findCarPoint();

        Assertions.assertThat(point).isEqualTo(1);
    }
}