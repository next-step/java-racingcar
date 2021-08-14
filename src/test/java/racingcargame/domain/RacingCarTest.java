package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String carName = "a,b";
        RacingCar racingCar = new RacingCar(new RacingCarName(carName));

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
        String carName = "a,b";
        RacingCar racingCar = new RacingCar(new RacingCarName(carName));

        int actual = racingCar.tryToMove(input);

        assertEquals(expected, actual);
    }

    @DisplayName("우승한 자동차인지 확인할 수 있다.")
    @Test
    void isWinner() {
        final int winnerDistance = 1;
        RacingCar car = new RacingCar(new RacingCarName("a"));
        car.tryToMove(5);

        boolean actual = car.isWinner(winnerDistance);

        assertTrue(actual);
    }
}
