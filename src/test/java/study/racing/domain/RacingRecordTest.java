package study.racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRecordTest {

    @Test
    void 차량들을_등록할수있다() {
        RacingRecord racingRecord = new RacingRecord(Arrays.asList(new Car(), new Car()));
        assertThat(racingRecord.getRecords()).hasSize(2);
    }

    @Test
    void 레이싱게임_차량의_회차별_거리를_기록할수있다() {
        Car car = new Car();
        int round = 1, distance = 2;
        RacingRecord racingRecord = new RacingRecord(Arrays.asList(car));
        racingRecord.record(car, round, distance);

        assertThat(racingRecord.getRecords().get(car).get(1)).isEqualTo(2);

        round = 2;
        distance = 3;
        racingRecord.record(car, round, distance);


        assertThat(racingRecord.getRecords().get(car).get(2)).isEqualTo(3);
    }

    @Test
    void 기록으로부터_승자를_알수있다() {
        Car pobi = new Car();
        Car crong = new Car();
        RacingRecord racingRecord = new RacingRecord(Arrays.asList(pobi, crong));
        racingRecord.record(pobi, 1, 1);
        racingRecord.record(pobi, 2, 2);
        racingRecord.record(crong, 1, 1);
        racingRecord.record(crong, 2, 1);

        assertThat(racingRecord.findWinners()).hasSize(1);

        racingRecord.record(crong, 2, 2);
        assertThat(racingRecord.findWinners()).hasSize(2);
    }
}
