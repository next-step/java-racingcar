package racingCar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.lineSeparator;
import static java.lang.System.setIn;

public class RacingCarTest {
    @Test
    void GameTest(){
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));
        RacingCar.main(null);
    }
}
