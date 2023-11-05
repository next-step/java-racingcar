package me.namuhuchutong.step4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차는 랜덤한 값 0 ~ 9에서 4 이상일 경우 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void car_moves_when_value_is_more_than_4(int givenRandomValue) {
        //given
        Car car = new Car();

        //when
        car.move(givenRandomValue);

        //then
        assertEquals(car.getPosition(), 1);
    }
}
