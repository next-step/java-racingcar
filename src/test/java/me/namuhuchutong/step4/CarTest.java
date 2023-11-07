package me.namuhuchutong.step4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private RacingRule alwaysMoveRule;

    @BeforeEach
    void init() {
        alwaysMoveRule = () -> true;
    }

    @DisplayName("자동차는 움직일 때 1칸 움직인다.")
    @ParameterizedTest(name = "given times : {0}")
    @ValueSource(ints = {1,2,3,4,5,6,7,9})
    void car_moves_only_one(int givenIterateNumber) {
        //given
        Car car = new Car("Tester");
        int alwaysMoveCondition = 4;

        // when
        for (int i = 0; i < givenIterateNumber; i++) car.move(alwaysMoveRule);

        //then
        assertEquals(car.getPosition(), givenIterateNumber);
    }
}
