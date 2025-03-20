package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RacingCarTest {

    private RacingCar car;
    RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);

    @BeforeEach
    void setUp() {
        car = spy(new RacingCar(0, mockGenerator));
    }

    @Test
    void progress() {
        when(mockGenerator.makeRandomNumber()).thenReturn(4);
        int expected = car.getPosition() + 1;

        car.progress();

        assertEquals(expected, car.getPosition());
    }
}
