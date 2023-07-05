package racingcar.car.ui;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.car.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.ui.CarFormatter;
import racingcar.car.ui.DefaultCarFormatter;

class DefaultCarFormatterTest {


    @Test
    @DisplayName("Car 객체를 받아서 자동차 이름과 주행 거리를 표시한다.")
    void test1() {
        Car car = new Car(5, "pobi");
        CarFormatter formatter = new DefaultCarFormatter();

        assertThat(formatter.format(car)).isEqualTo("pobi : -----");
    }
}