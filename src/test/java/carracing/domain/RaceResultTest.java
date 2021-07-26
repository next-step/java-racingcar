package carracing.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RaceResultTest {

    @Test
    @DisplayName("roundRecords 리스트가 null 인 경우")
    public void roundRecordsNull() {
        // given
        List<RoundRecord> roundRecords = null;
        String message = RaceResult.NON_NULL_ROUND_RECORDS;

        // when
        ThrowingCallable throwingCallable = () -> new RaceResult(roundRecords);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("roundRecords 리스트가 비어있는 경우")
    public void roundRecordsEmpty() {
        // given
        List<RoundRecord> roundRecords = Collections.EMPTY_LIST;
        String message = RaceResult.NOT_EMPTY_ROUND_RECORDS;

        // when
        ThrowingCallable throwingCallable = () -> new RaceResult(roundRecords);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("정상적으로 RoundRecords 반환하는지 테스트")
    public void getRoundRecords() {
        // given
        List<CarStatus> carStatuses = Arrays.asList(
                new CarStatus("iiaii", 1),
                new CarStatus("!!e!!", 2));
        List<RoundRecord> roundRecords = Collections.singletonList(new RoundRecord(carStatuses));
        int expectedSize = 1;

        // when
        RaceResult raceResult = new RaceResult(roundRecords);

        // then
        assertThat(raceResult.getRoundRecords().size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("winner 1명인 경우 테스트")
    public void oneWinner() {
        // given
        List<CarStatus> carStatuses = Arrays.asList(
                new CarStatus("iiaii", 1),
                new CarStatus("!!e!!", 2));
        List<RoundRecord> roundRecords = Collections.singletonList(new RoundRecord(carStatuses));
        int expectedWinnerSize = 1;
        String expectedWinnerName = "!!e!!";

        // when
        RaceResult raceResult = new RaceResult(roundRecords);

        // then
        assertThat(raceResult.getWinners().size()).isEqualTo(expectedWinnerSize);
        assertThat(raceResult.getWinners()).contains(expectedWinnerName);
    }

    @Test
    @DisplayName("winner 2명인 경우 테스트")
    public void twoWinners() {
        // given
        List<CarStatus> carStatuses = Arrays.asList(
                new CarStatus("iiaii", 2),
                new CarStatus("!!e!!", 2));
        List<RoundRecord> roundRecords = Collections.singletonList(new RoundRecord(carStatuses));
        int expectedWinnerSize = 2;
        String expectedWinnerName1 = "iiaii";
        String expectedWinnerName2 = "!!e!!";

        // when
        RaceResult raceResult = new RaceResult(roundRecords);

        // then
        assertThat(raceResult.getWinners().size()).isEqualTo(expectedWinnerSize);
        assertThat(raceResult.getWinners())
                .contains(expectedWinnerName1)
                .contains(expectedWinnerName2)
                .containsExactly(expectedWinnerName1, expectedWinnerName2);
    }

}