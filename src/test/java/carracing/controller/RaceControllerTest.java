package carracing.controller;

import carracing.domain.RaceManager;
import carracing.domain.RaceResult;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceControllerTest {

    private final RaceController raceController = new RaceController(new RaceManager());

    @Test
    @DisplayName("carNames 리스트가 null 인 경우")
    public void carNamesNull() {
        // given
        List<String> carNames = null;
        int roundNumber = 3;
        String message = RaceController.NON_NULL_CAR_NAMES;

        // when
        ThrowingCallable throwingCallable = () -> raceController.play(carNames, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("carNames 리스트가 비어있는 경우")
    public void carNamesEmpty() {
        // given
        List<String> carNames = Collections.EMPTY_LIST;
        int roundNumber = 3;
        String message = RaceController.NOT_EMPTY_CAR_NAMES;

        // when
        ThrowingCallable throwingCallable = () -> raceController.play(carNames, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "입력값이 숫자가 0 보다 같거나 작은 경우 | {arguments}")
    @CsvSource(value = {"-1:-1", "0:0", "-3:-3"}, delimiter = ':')
    public void lteZero(int roundNumber, int illegalNumber) {
        // given
        List<String> carNames = Arrays.asList("iiaii", "!!e!!");
        String message = RaceController.LESS_THAN_OR_EQUAL_ZERO + illegalNumber;

        // when
        ThrowingCallable throwingCallable = () -> raceController.play(carNames, roundNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("play 테스트")
    public void play() {
        // given
        List<String> carNames = Arrays.asList("iiaii", "!!e!!");
        int roundNumber = 3;
        int expectedWinnerSizeGte = 1;
        int expectedWinnerSizeLte = 2;
        int expectedRoundNumber = 4;

        // when
        RaceResult raceResult = raceController.play(carNames, roundNumber);
        int winnerSize = raceResult.getWinners().size();
        int roundRecordSize = raceResult.getRoundRecords().size();

        // then
        assertThat(winnerSize)
                .isGreaterThanOrEqualTo(expectedWinnerSizeGte)
                .isLessThanOrEqualTo(expectedWinnerSizeLte);
        assertThat(roundRecordSize)
                .isEqualTo(expectedRoundNumber);
    }

}
