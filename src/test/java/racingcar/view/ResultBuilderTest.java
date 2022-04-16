package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBuilderTest {


    @Test
    @DisplayName("position 숫자 만큼 '-'가 추가되어 반환된다.")
    void buildResult() {
        Car car = new Car("tom");
        car.stopOrGo(9);
        car.stopOrGo(9);

        assertThat(new ResultBuilder(car.getPosition()).build()).isEqualTo("--");
    }

}