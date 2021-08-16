package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.MoveStategy;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategyImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car(new CarName("joo"));
    }

    @DisplayName(value = "자동차 후진 테스트")
    @Test
    void 후진() {
        car.moveOperator(() -> 3);
        int result = car.getPosition().getCoordinate();
        assertEquals(result, 0);
    }

    @DisplayName(value = "자동차 전진 테스트")
    @Test
    void 전진() {
        car.moveOperator(() -> 5);
        int result = car.getPosition().getCoordinate();
        assertEquals(result, 1);
    }

}