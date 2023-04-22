package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingGameService;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsServiceTest {


    @Test
    @DisplayName("자동차 대수를 입력한다")
    void input_car_number() {
        mockInputStream("3");

        RacingGameService car = new RacingGameService();
        car.setCarNumber();
        assertThat(car.getCarNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이동 횟수를 입력한다")
    void input_car_move_times() {
        mockInputStream("3");

        RacingGameService car = new RacingGameService();
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
