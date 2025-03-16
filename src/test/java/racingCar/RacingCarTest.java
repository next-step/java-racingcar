package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp() {
        car = spy(new RacingCar(0));
    }

    @Test
    void makeRandomNum() {
        int random = car.makeRandomNum();
        assertTrue(random >= 0 && random <= 9);
    }

    @Test
    void progress() {
        // given
        doReturn(4).when(car).makeRandomNum();
        int expected = car.getPos()+1;

        // when
        car.progress();

        // then
        assertEquals(expected, car.getPos());
    }
}
