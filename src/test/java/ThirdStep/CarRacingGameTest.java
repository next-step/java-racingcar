package ThirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CarRacingGameTest {
    private final static int CAR_COUNT = 3;
    private final static int ATTEMPTS = 5;

    @BeforeEach
    void initInput() {
        InputStream settings = new ByteArrayInputStream(String.format("%d %d", CAR_COUNT, ATTEMPTS).getBytes());
        System.setIn(settings);
    }
    @Test
    void run() {
        CarRacingGame.run();
    }
}
