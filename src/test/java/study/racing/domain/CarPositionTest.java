package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarPositionTest {

    @Test
    void 자동차위치의_초기값은_0이다() {
        CarPosition carPosition = new CarPosition();

        assertEquals(0, carPosition.getValue());
    }

    @Test
    void 자동차위치를_증가시키면_증가된_자동차위치를_반환한다() {
        CarPosition increasedCarPosition = new CarPosition().increase();

        assertEquals(1, increasedCarPosition.getValue());
    }

    @Test
    void 같은_위치이면_동등성을_가진다() {
        CarPosition carPosition1 = new CarPosition();
        CarPosition carPosition2 = new CarPosition();

        assertEquals(carPosition1, carPosition2);
    }
}
