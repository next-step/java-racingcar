package me.namuhuchutong.step3;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 위치를 음수로 초기화할 수 없다.")
    @Test
    void can_not_initialize_car_with_negative_number() {
        //when, then
        assertThatThrownBy(() -> new Car(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 4이상이라면 자동차는 1칸 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_car_by_condition(int value) {
        //given
        Car car = new Car();

        //when
        car.move(imitateRandomCondition(value));

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("값이 4미만일 경우 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void do_not_move_car_by_condition(int value) {
        //given
        Car car = new Car();

        //when
        car.move(imitateRandomCondition(value));

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 표시 문자열 길이와 자동차의 위치 값은 동일하다")
    @ParameterizedTest(name = "from: {0}, to: {1}, expected: {2}")
    @CsvSource(value = {"4,6,2", "1,9,5", "9,9,0"})
    void string_indicator_length_and_car_position_is_same_value(int from, int to, int expected) {
        //given
        Car car = new Car();

        //when
        IntStream.range(from, to)
                 .mapToObj(this::imitateRandomCondition)
                 .forEach(car::move);

        //then
        assertThat(car.getPositionToString().length()).isEqualTo(expected);
    }

    private boolean imitateRandomCondition(int value) {
        return value > 3;
    }
}
