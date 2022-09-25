package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 4이상이면 달리기")
    void race_when_random_value_greater_then_4(int runUnit) {
        //given
        Car car = new Car(((min, max) -> runUnit));
        //when
        car.run();
        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("랜덤값이 3이하면 달리지 않기")
    void do_not_race_when_random_value_less_than_3(int runUnit) {
        //given
        Car car = new Car(((min, max) -> runUnit));
        //when
        car.run();
        //then
        assertThat(car.getDistance()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("이동거리 확인하기")
    void check_distance(int numberOfTimes) {
        //given
        Car car = new Car((min, max) -> 9);
        //when
        for (int time = 0; time < numberOfTimes; time++) {
            car.run();
        }
        //then
        assertThat(car.getDistance()).isEqualTo(numberOfTimes);
    }
}