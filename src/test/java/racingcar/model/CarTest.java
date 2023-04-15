package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.service.RacingGame;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_go_or_stop_when_condition_is_four(int randomNumber, boolean expected) {
        Car car = new Car(0);
        Random random = new Random();
        random.nextInt(10);

        assertThat(car.goOrStop(4, randomNumber)).isEqualTo(expected);
    }


    @Test
    @DisplayName("위치 값이 1씩 증가 확인")
    void check_position_value_plus_one(){
        Car car = new Car(0);
        car.plugPosition();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}