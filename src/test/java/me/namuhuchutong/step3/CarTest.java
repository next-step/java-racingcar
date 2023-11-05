package me.namuhuchutong.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 위치를 음수로 초기화할 수 없다.")
    @Test
    void can_not_initialize_car_with_negative_number() {
        // when, then
        assertThatThrownBy(() -> new Car(- 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 조건을 만족할 때, 1칸 움직인다.")
    @Test
    void car_moves_only_1_when_meet_the_condition() {
        //given
        Car car = new Car();
        RacingRule racingRule = new DefaultRacingRule();

        //when
        car.move(racingRule);
        int result = car.getPosition();

        //then
        assertThat(result).isEqualTo(1);
    }
}
