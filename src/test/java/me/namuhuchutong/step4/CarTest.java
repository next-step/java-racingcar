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
        Car car = new Car("Tester");

        //when
        car.move(givenRandomValue);

        //then
        assertEquals(car.getPosition(), 1);
    }

    @DisplayName("자동차가 랜덤한 값 0 ~ 9에서 4 미만일 경우 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1,2,3})
    void car_does_not_move_when_value_is_less_than_4(int givenRandomValue) {
        //given
        Car car = new Car("Tester");

        //when
        car.move(givenRandomValue);

        //then
        assertEquals(car.getPosition(), 0);
    }

    @DisplayName("자동차는 움직일 때 1칸 움직인다.")
    @ParameterizedTest(name = "given times : {0}")
    @ValueSource(ints = {1,2,3,4,5,6,7,9})
    void car_moves_only_one(int givenIterateNumber) {
        //given
        Car car = new Car("Tester");
        int alwaysMoveCondition = 4;

        //when
        for (int i = 0; i < givenIterateNumber; i++) {
            car.move(alwaysMoveCondition);
        }

        //then
        assertEquals(car.getPosition(), givenIterateNumber);
    }
}
