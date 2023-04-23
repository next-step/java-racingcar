package racingcar.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Point;

@DisplayName("전진 전략 테스트")
class MovableNumberGeneratorStrategyTest {

    @DisplayName("전진 전략은 차가 이동한다")
    @Test
    void 전진하는_조건_테스트() {
        Car car = new Car("korea");

        Point point = car.move(new MovableNumberGeneratorStrategy());
        int actual = point.getPoint();

        Assertions.assertThat(actual).isEqualTo(1);
    }
}