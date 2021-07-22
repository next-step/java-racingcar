package study.step3;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceManagerTest {

    RaceManager raceManager = new RaceManager();

    @ParameterizedTest(name = "입력값이 null 인 경우 | {arguments}")
    @CsvSource(value = {":3", "3:", ":"}, delimiter = ':')
    public void nullInput(String carNumber, String roundNumber) {
        // given
        String message = RaceManager.NULL_INPUT;

        // when
        ThrowingCallable throwingCallable = () -> raceManager.register(carNumber, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "입력값이 숫자가 아닌 경우 | {arguments}")
    @CsvSource(value = {"2:*:\"*\"", "%:12:\"%\"", "42:1,000:\"1,000\""}, delimiter = ':')
    public void notNumber(String carNumber, String roundNumber, String notNumber) {
        // given
        String message = "For input string: " + notNumber;

        // when
        ThrowingCallable throwingCallable = () -> raceManager.register(carNumber, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "입력값이 숫자가 0 보다 같거나 작은 경우 | {arguments}")
    @CsvSource(value = {"-1:3", "0:3", "2:-3"}, delimiter = ':')
    public void lteZero(String carNumber, String roundNumber) {
        // given
        String message = RaceManager.LESS_THAN_OR_EQUAL_ZERO;

        // when
        ThrowingCallable throwingCallable = () -> raceManager.register(carNumber, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}
