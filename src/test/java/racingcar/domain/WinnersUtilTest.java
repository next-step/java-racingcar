package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnersUtilTest {

    @Test
    void findMaxPosition() {
        Car 짱구 = new Car("짱구", 1);
        Car 철수 = new Car("철수", 2);
        List<Car> cars = List.of(짱구, 철수);

        assertThat(WinnersUtil.findMaxPosition(cars)).isEqualTo(2);
    }

    @Test
    void determineWinners() {
        Car 짱구 = new Car("짱구", 1);
        Car 철수 = new Car("철수", 2);
        List<Car> cars = List.of(짱구, 철수);
        int maxPosition = WinnersUtil.findMaxPosition(cars);

        assertThat(WinnersUtil.determineWinners(cars, maxPosition)).contains("철수");
    }
}