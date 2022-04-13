package camp.nextstep.racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static java.lang.System.*;

class CarRacingApplicationTest {

    @Test
    void start() {
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));
        CarRacingApplication.main(null);
    }
}