package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.strategy.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBuilderTest {

    MovingStrategy alwaysGoMoving = new MovingStrategy() {
        @Override
        public boolean isMoving() {
            return true;
        }
    };

    @Test
    @DisplayName("tom 자동차가 두번 전진하면 'tom : --'를 반환한다.")
    void buildResult() {
        Car car = new Car("tom", alwaysGoMoving);
        car.move();
        car.move();

        assertThat(new ResultBuilder(car.getPosition(), car.getCarName()).build()).isEqualTo("tom : --");
    }

}