package camp.nextstep.racingcar;

import camp.nextstep.Application;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static java.lang.System.*;

class CarRacingTest {

    @Test
    void start() {
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));
        Application.main(null);
    }
}