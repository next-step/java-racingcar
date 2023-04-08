package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_go_or_stop_when_condition_is_four(int randomNumber, boolean expected) {
        RacingGame car = new RacingGame();
        assertThat(car.goOrStop(4, randomNumber)).isEqualTo(expected);
    }


    private void mockInputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
