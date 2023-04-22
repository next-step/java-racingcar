package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_go_or_stop_when_condition_is_four(int randomNumber, boolean expected) {
        Car car = new Car();
        assertThat(car.goOrStop(4, randomNumber)).isEqualTo(expected);
    }


    @Test
    @DisplayName("위치 값이 1씩 증가 확인")
    void check_position_value_plus_one(){
        Car car = new Car();
        car.plugPosition();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_move_when_value_over_the_condition_four() {
        Car car = new Car();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_move_when_value_under_the_condition_four() {
        Car car = new Car();
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}