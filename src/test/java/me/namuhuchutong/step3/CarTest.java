package me.namuhuchutong.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

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

    private boolean imitateRandomCondition(int value) {
        return value >= 3;
    }
}
