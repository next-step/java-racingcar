package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceRecordsTest {

    @Test
    @DisplayName("경기 우승자를 가져온다. 우승자는 한명 이상일 수 있다.")
    public void race_record_winner() {
        List<RaceRecord> list = Arrays.asList(
                new RaceRecord(new CarName("carA"), new Position(1)),
                new RaceRecord(new CarName("carB"), new Position(2)),
                new RaceRecord(new CarName("carC"), new Position(2))
        );
        RaceRecords raceRecords = new RaceRecords(list);
        List<CarName> winners = raceRecords.winners();

        assertThat(winners).hasSize(2);
    }
}