package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fixture.RacingCarFixture;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RecordsTest {

    @DisplayName("각 라운드의 경주 내용을 기록할 수 있다.")
    @Test
    void record() {
        // given
        Lap lap = Lap.from(1);
        Record record = Record.from(RacingCarFixture.RACING_CARS);
        Records beforeRecord = Records.EMPTY_RECORDS;

        // when
        Records afterRecord = beforeRecord.record(lap, record);

        // then
        assertAll(
                () -> assertThat(beforeRecord.getValues()).size().isEqualTo(0),
                () -> assertThat(afterRecord.getValues()).size().isEqualTo(1)
        );
    }

    @DisplayName("우승자 이름을 조회할 수 있다.")
    @Test
    void getWinner() {
        // given
        Record record = new Record(Arrays.asList(
                new Score(new Name("a"), Position.from(10)),
                new Score(new Name("b"), Position.from(20)),
                new Score(new Name("c"), Position.from(30))
        ));
        List<Name> expected = Arrays.asList(new Name("c"));

        // when
        List<Name> winners = record.getWinner();

        // then
        assertThat(winners).isEqualTo(expected);
    }
}
