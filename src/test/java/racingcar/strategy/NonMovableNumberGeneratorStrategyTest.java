package racingcar.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("정지 전략 테스트")
class NonMovableNumberGeneratorStrategyTest {

    @DisplayName("정지 전략은 차가 이동하지 않는다")
    @Test
    void 정지_전략_테스트() {
        NumberGeneratorStrategy numberGeneratorStrategy = new NonMovableNumberGeneratorStrategy();
        Car car = new Car();
        car.initMoveStrategy(numberGeneratorStrategy);

        car.move();
        int point = car.findCarPoint();

        Assertions.assertThat(point).isEqualTo(0);
    }
}