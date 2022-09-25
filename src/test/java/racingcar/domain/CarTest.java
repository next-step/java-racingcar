package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(car.showDistance()).isEqualTo(1);
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
        assertThat(car.showDistance()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("이동거리 확인하기")
    void check_distance(int numberOfTimes) {
        //given
        Car car = new Car((min, max) -> 9);
        //when
        IntStream.range(0, numberOfTimes).forEach(a -> car.run());
        //then
        assertThat(car.showDistance()).isEqualTo(numberOfTimes);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 빈값이면 에러")
    @NullAndEmptySource
    void car_name_null_or_empty(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백 문자열이면 에러 ")
    @NullAndEmptySource
    void car_name_blank() {
        assertThatThrownBy(() -> new Car(" ")).isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("자동차 이름이 5를 넘어가면 에러")
    void car_name_size_over_5() {
        assertThatThrownBy(() -> new Car("asdfgef"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("5");

    }

}