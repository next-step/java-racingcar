package winner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.RacingGameInputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:42
 */
public class RacingWinnerTest {
    @Test
    void play_car_race_winner_game() {
        CarRaceWinnerGame carRaceWinnerGame = new CarRaceWinnerGame(new String[]{"pobi", "kim", "lee"}, 5);
        carRaceWinnerGame.play();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 3})
    void car_move_test(int fuel) {
        Car car = new Car("ergo");
        car.move(fuel);
        assertThat(car.getPosition()).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 3})
    void car_show_position(int fuel) {
        Car car = new Car("ergo");
        car.move(fuel);
        assertThat(car.showPosition()).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "ergo"})
    void string_null_or_empty_test(String value) {
        assertThat(CheckUtil.stringNullOrEmpty(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "5", "ergo"})
    void is_number(String value) {
        assertThat(CheckUtil.isNumber(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1})
    void greater_than_zero(int value) {
        assertThat(CheckUtil.greaterThanZero(value)).isTrue();
    }

}
