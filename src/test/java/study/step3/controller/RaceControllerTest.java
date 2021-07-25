package study.step3.controller;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step3.service.RaceService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceControllerTest {

    RaceController raceController = new RaceController(new RaceService());

    @ParameterizedTest(name = "입력값이 숫자가 0 보다 같거나 작은 경우 | {arguments}")
    @CsvSource(value = {"-1:3:-1", "0:3:0", "2:-3:-3"}, delimiter = ':')
    public void lteZero(int carNumber, int roundNumber, int illegalNumber) {
        // given
        String message = raceController.LESS_THAN_OR_EQUAL_ZERO + illegalNumber;

        // when
        ThrowingCallable throwingCallable = () -> raceController.play(carNumber, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}
