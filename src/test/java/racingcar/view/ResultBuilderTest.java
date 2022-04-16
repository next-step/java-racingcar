package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBuilderTest {


    @Test
    @DisplayName("tom 자동차가 두번 가면 'tom : --'를 반환한다.")
    void buildResult() {
        Car car = new Car("tom");
        car.stopOrGo(9);
        car.stopOrGo(9);

        assertThat(new ResultBuilder(car.getPosition(), car.getCarName()).build()).isEqualTo("tom : --");
    }

}