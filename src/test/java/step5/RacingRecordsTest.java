package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Name;
import step5.domain.Position;
import step5.domain.RacingRecord;
import step5.domain.RacingRecords;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRecordsTest {

    @Test
    void 선두_Cars_찾기_테스트(){
        RacingRecord record1 = new RacingRecord(new Name("kim"), new Position(5));
        RacingRecord record2 = new RacingRecord(new Name("won"), new Position(6));
        RacingRecord record3 = new RacingRecord(new Name("sakku"), new Position(6));

        RacingRecords racingRecords = new RacingRecords(Arrays.asList(record1, record2, record3));

        assertThat(racingRecords.firstRacingCars()).containsExactly("won", "sakku");
    }

}
