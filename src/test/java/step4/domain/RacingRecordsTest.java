package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRecordsTest {

    @Test
    void 선두_Cars_찾기_테스트(){
        RacingRecord record1 = new RacingRecord("kim", 5);
        RacingRecord record2 = new RacingRecord("won", 6);
        RacingRecord record3 = new RacingRecord("sakku", 6);

        RacingRecords racingRecords = new RacingRecords(Arrays.asList(record1, record2, record3));

        assertThat(racingRecords.firstRacingCars()).containsExactly("won", "sakku");
    }

}