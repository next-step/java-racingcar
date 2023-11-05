package me.namuhuchutong.step3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @DisplayName("자동차 수는 음수이거나 0이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void test(int numberOfCars) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> Cars.createCars(numberOfCars));
    }
}
