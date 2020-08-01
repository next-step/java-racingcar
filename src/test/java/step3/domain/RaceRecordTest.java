package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.RaceRecord.of;

class RaceRecordTest {

    @DisplayName("각 Lap 마다 경기기록 생성 TEST")
    @ParameterizedTest
    @CsvSource(value = {"1:1",
                        "2:2",
                        "3:3"},
               delimiter = ':')
    void ofNowRecords(int lap, int result) {
        assertThat(of()
                       .ofRecordResult(lap)
                       .size()).isEqualTo(result);
    }

    @DisplayName("직진 기능 TEST")
    @ParameterizedTest
    @CsvSource(value = {"1:0"},
               delimiter = ':')
    void goAhead(int chanceGoAhead, int result) {
        RaceRecord alwaysStraight = new RaceRecord(0,
                                                   0,
                                                   chanceGoAhead);
        assertThat(alwaysStraight.goAhead(chanceGoAhead)).isEqualTo(result);
    }
}