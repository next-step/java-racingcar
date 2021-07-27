package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    @DisplayName("값이 4미만일 경우 멈춘다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1$''"
            , "3$''"}
            , delimiter = '$')
    void stop(int input, String expected) {
        RacingCar racingCar = new RacingCar();
        String actual = racingCar.doRandomCalculation(input);
        assertEquals(expected, actual);
    }

    @DisplayName("값이 4이상일 경우 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4$-"
            , "9$-"}
            , delimiter = '$')
    void move(int input, String expected) {
        RacingCar racingCar = new RacingCar();
        String actual = racingCar.doRandomCalculation(input);
        assertEquals(expected, actual);
    }
}
