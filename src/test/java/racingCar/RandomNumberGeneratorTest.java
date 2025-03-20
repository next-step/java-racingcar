package racingCar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RandomNumberGeneratorTest {
    @Test
    public void testMakeRandomNumber_WithMock() {
        RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.makeRandomNumber()).thenReturn(4);

        assertEquals(4, mockGenerator.makeRandomNumber());
        verify(mockGenerator).makeRandomNumber();
    }
}
