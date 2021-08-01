package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    @DisplayName("값이 4미만일 경우 멈춘다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0$0"
            , "1$0"
            , "2$0"
            , "3$0"}
            , delimiter = '$')
    void stop(int input, int expected) {
        RacingCar racingCar = new RacingCar();

        int actual = racingCar.tryToMove(input);

        assertEquals(expected, actual);
    }

    @DisplayName("값이 4이상일 경우 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4$1"
            , "5$1"
            , "6$1"
            , "7$1"
            , "8$1"
            , "9$1"}
            , delimiter = '$')
    void move(int input, int expected) {
        RacingCar racingCar = new RacingCar();

        int actual = racingCar.tryToMove(input);

        assertEquals(expected, actual);
    }
}
