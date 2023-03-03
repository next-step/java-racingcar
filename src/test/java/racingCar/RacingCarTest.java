package racingCar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    @Test
    void racingTest() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun\n5".getBytes()));
        RacingCar racingCar = new RacingCar();
        racingCar.race();
    }

    @Test
    void racingInputLengthErrorTest() {
        System.setIn(new ByteArrayInputStream("pobi,woni,november\n5".getBytes()));
        RacingCar racingCar = new RacingCar();
        racingCar.race();
    }
}
