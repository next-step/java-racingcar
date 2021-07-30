package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingRecords;
import racingcar.utils.RacingRecordManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 기록 테스트")
class RacingRecordManagerTest {

    @Test
    @DisplayName("자동차 경주 우승자 확인")
    void racingWinnerTest() {
        // given
        RacingRecord bmw = new RacingRecord(new Car("bmw"), 10);
        RacingRecord benz = new RacingRecord(new Car("benz"), 12);
        RacingRecord audi = new RacingRecord(new Car("audi"), 13);

        RacingRecords finalRacingRecords = new RacingRecords(Arrays.asList(bmw, benz, audi));

        List<RacingRecords> racingRecords = Collections.singletonList(finalRacingRecords);

        // when
        String winner = RacingRecordManager.getRacingWinner(racingRecords).get(0);

        // then
        assertThat(winner).isEqualTo("audi");
    }
}