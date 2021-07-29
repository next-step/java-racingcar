package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingRecord;
import racingcar.utils.RacingRecordManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 기록 테스트")
class RacingRecordManagerTest {

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
        String winner = RacingRecordManager.getRacingWinner(racingRecords).get(0);

        //then
        assertThat(winner).isEqualTo("benz");
    }
}