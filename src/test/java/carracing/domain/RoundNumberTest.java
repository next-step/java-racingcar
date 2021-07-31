package carracing.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundNumberTest {

    @ParameterizedTest(name = "입력값이 숫자가 0 보다 같거나 작은 경우 | {arguments}")
    @CsvSource(value = {"-1:-1", "0:0", "-3:-3"}, delimiter = ':')
    public void lteZero(int roundNumber, int illegalNumber) {
        // given
        String message = RoundNumber.LESS_THAN_OR_EQUAL_ZERO + illegalNumber;

        // when
        ThrowingCallable throwingCallable = () -> new RoundNumber(roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "RoundIntStream 가져오기 | {arguments}")
    @CsvSource(value = {"1:1", "3:3", "6:6"}, delimiter = ':')
    public void getRoundIntStream(int roundNumber, int expectedNumber) {
        // given
        RoundNumber round = new RoundNumber(roundNumber);

        // when
        IntStream result = round.getRoundIntStream();

        // then
        assertThat(result.count()).isEqualTo(expectedNumber);
    }

}