package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 기록 테스트")
class RacingRecordTest {

    @Test
    @DisplayName("자동차 경주 우승자 확인")
    void racingWinnerTest() {
        // given
        List<RacingRecord> finalRacingRecord = new ArrayList<>();
        finalRacingRecord.add(new RacingRecord(new Car("bmw"), 10));
        finalRacingRecord.add(new RacingRecord(new Car("benz"), 12));
        finalRacingRecord.add(new RacingRecord(new Car("audi"), 12));

        List<List<RacingRecord>> racingRecords = new ArrayList<>();
        racingRecords.add(finalRacingRecord);

        // when
        String winner = RacingRecord.getRacingWinner(racingRecords).get(0);

        //then
        assertThat(winner).isEqualTo("benz");
    }
}