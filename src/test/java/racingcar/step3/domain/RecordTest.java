package racingcar.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.common.Consts;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-10 오후 12:51.
 * Developer : Seo.
 */
class RecordTest {
    Car car1;
    Car car2;
    Car car3;
    Record record;
    Cars cars;
    String inputNames;

    @BeforeEach
    void setUp() {
        this.car1 = new Car("pobi");
        this.car2 = new Car("crong");
        this.car3 = new Car("honux");
        this.record = new Record();
        this.inputNames = "pobi,crong,honux";
        this.cars = new Cars(inputNames);
    }

    @Test
    @DisplayName("최고 기록 확인")
    void whenTwoMove_thenShouldBeTheBestTwo() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn, turnRecords);
        assertThat(record.getBestRecord()).isEqualTo(1);

        car2.move(Consts.INVALID_VALUE + 1);
        car2.move(Consts.INVALID_VALUE + 1);
        record.record(car2, turn, turnRecords);
        assertThat(record.getBestRecord()).isEqualTo(2);
    }

    @Test
    @DisplayName("턴 기록 확인")
    void whenTwoCarsParticipate_thenTheTurnResultShouldHaveTwo() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn, turnRecords);

        car2.move(Consts.INVALID_VALUE);
        record.record(car2, turn, turnRecords);

        assertThat(record.getTotalRecords().get(turn)).hasSize(2);
    }

    @Test
    @DisplayName("총 기록 확인")
    void whenTheRaceRunsTwice_thenTheTotalShouldHaveTwo() {
        int turn = 1;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn, turnRecords);
        assertThat(record.getTotalRecords()).hasSize(1);

        turn = 2;
        car1.move(Consts.INVALID_VALUE + 1);
        record.record(car1, turn, turnRecords);
        assertThat(record.getTotalRecords()).hasSize(2);
    }

}