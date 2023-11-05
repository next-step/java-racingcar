package me.namuhuchutong.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 위치를 음수로 초기화할 수 없다.")
    @Test
    void can_not_initialize_car_with_negative_number() {
        // when, then
        assertThatThrownBy(() -> new Car(new DefaultRacingRule(), - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
