package study.step3.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step3.domain.CarManager;
import study.step3.domain.RaceManager;
import study.step3.domain.RoundManager;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceManagerTest {

    CarManager carManager = new CarManager();
    RoundManager roundManager = new RoundManager();
    RaceManager raceManager = new RaceManager(carManager, roundManager);

    @ParameterizedTest(name = "입력값이 숫자가 0 보다 같거나 작은 경우 | {arguments}")
    @CsvSource(value = {"-1:3:-1", "0:3:0", "2:-3:-3"}, delimiter = ':')
    public void lteZero(int carNumber, int roundNumber, int illegalNumber) {
        // given
        String message = RaceManager.LESS_THAN_OR_EQUAL_ZERO + illegalNumber;

        // when
        ThrowingCallable throwingCallable = () -> raceManager.manageRace(carNumber, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}
