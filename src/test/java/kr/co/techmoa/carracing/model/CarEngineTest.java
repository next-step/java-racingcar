package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.MoveStategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarEngineTest {

    @Test
    void 전진() {
        CarEngine carEngine = new CarEngine();
        int move = carEngine.moveOperator(() -> 4);

        assertEquals(1, move);
    }

    @Test
    void 후진() {
        CarEngine carEngine = new CarEngine();
        int move = carEngine.moveOperator(() -> 3);

        assertEquals(0, move);
    }
}