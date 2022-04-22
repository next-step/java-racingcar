package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.strategy.FixedMoving;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBuilderTest {

    @Test
    @DisplayName("tom 자동차가 두번 전진하면 'tom : --'를 반환한다.")
    void buildResult() {
        Car car = new Car("tom", FixedMoving.alwaysGo);
        car.move();
        car.move();

        assertThat(new ResultBuilder(car.position().get(), car.carName()).build()).isEqualTo("tom : --");
    }

}