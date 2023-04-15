package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.service.RacingGame;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {


    @Test
    @DisplayName("자동차 대수를 입력한다")
    void input_car_number() {
        mockInputStream("3");

        RacingGame car = new RacingGame();
        car.setCarNumber();
        assertThat(car.getCarNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이동 횟수를 입력한다")
    void input_car_move_times() {
        mockInputStream("3");

        RacingGame car = new RacingGame();
        car.setMoveTimes();
        assertThat(car.getMoveTimes()).isEqualTo(3);
    }

    private void mockInputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
