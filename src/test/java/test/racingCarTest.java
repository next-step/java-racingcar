package test;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingCar.RacingCar;

public class racingCarTest {

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
