package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void setUp() {
        RandomFactory randomFactory = mock(RandomFactory.class);
        when(randomFactory.getNextInt()).thenReturn(3);
        carRacing = new CarRacing(5, 3, randomFactory);
    }

    @Test
    @DisplayName("racing을 3번했을경우,결과값의 size는 3이어야한다.")
    void racingSizeTest() {
        List<String> results = carRacing.step();
        assertEquals(5, results.size());
    }

    @Test
    @DisplayName("input값이 4이하이므로 마지막 모든 결과값은 -이어야한다.")
    void racingContentTest() {
        List<String> results = carRacing.step();
        for (String raceText : results) {
            assertEquals(raceText,"-");
        }
    }
}
