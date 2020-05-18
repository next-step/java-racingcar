package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    // Test

    @DisplayName("check only")
    @ParameterizedTest
    @CsvSource(value = {"3:5"}, delimiter = ':')
    void testNormal(int carsCount, int tryTimes) {

        RacingGame racingGame = new RacingGame(carsCount, tryTimes);
        racingGame.play();

    }

    @DisplayName("Arguments check / input negative number to cars count.")
    @ParameterizedTest
    @CsvSource(value = {"-1:2", "-100:3"}, delimiter = ':')
    void testInputCarsCountNegativeNumber(int carsCount, int tryTimes) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    RacingGame racingGame = new RacingGame(carsCount, tryTimes);
                }
        );
    }

    @DisplayName("Arguments check / input negative number to play times count.")
    @ParameterizedTest
    @CsvSource(value = {"2:-1", "3:-100"}, delimiter = ':')
    void testInputPlayTimesNegativeNumber(int carsCount, int tryTimes) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    RacingGame racingGame = new RacingGame(carsCount, tryTimes);
                }
        );
    }


}