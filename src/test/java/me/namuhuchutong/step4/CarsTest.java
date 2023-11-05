package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @DisplayName("자동차 수는 음수이거나 0일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void number_of_cars_should_not_be_negative(int numberOfCars) {
        //when, then
        assertThatThrownBy(() -> Cars.createCars(numberOfCars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
