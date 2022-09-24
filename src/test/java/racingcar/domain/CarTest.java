package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 4이상이면 달리기")
    void race_when_random_value_greater_then_4(int random) {
        //given
        Car car = new Car(((min, max) -> random));
        //when
        car.run();
        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("랜덤값이 3이하면 달리지 않기")
    void do_not_race_when_random_value_less_than_3(int random) {
        //given
        Car car = new Car(((min, max) -> random));
        //when
        car.run();
        //then
        assertThat(car.getDistance()).isZero();
    }

    @Test
    @DisplayName("그래프 그리기")
    void test_distance() {
        //given
        Car car = new Car();
        //when
        car.run();
        car.run();
        //then
        assertThat(car.getDistance()).isEqualTo(2);
    }
}