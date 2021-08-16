package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.MoveStategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarEngineTest {

    @Test
    void 전진() {
        boolean move = new Car(new CarName("joo")).moveOperator(() -> 4);
        assertEquals(true, move);
    }

    @Test
    void 후진() {
        boolean move = new Car(new CarName("joo")).moveOperator(() -> 3);
        assertEquals(false, move);
    }
}