package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("달리기 가능하면 달리기")
    void race_when_random_value_greater_then_4() {
        //given
        Car car = new Car("a");
        //when
        car.run(() -> true);
        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("달리지 못하면 달리지 않기")
    void do_not_race_when_random_value_less_than_3() {
        //given
        Car car = new Car("b");
        //when
        car.run(() -> false);
        //then
        assertThat(car.getDistance()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("이동거리 확인하기")
    void check_distance(int numberOfTimes) {
        //given
        Car car = new Car("c");
        //when
        car.run(numberOfTimes, () -> true);
        //then
        assertThat(car.getDistance()).isEqualTo(numberOfTimes);
    }

}