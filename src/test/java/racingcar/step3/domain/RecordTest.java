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
    Car car1 = null;
    Car car2 = null;
    Car car3 = null;
    Record record = null;

    @BeforeEach
    void setUp() {
        car1 = new Car("pobi");
        car2 = new Car("crong");
        car3 = new Car("honux");
        record = new Record(Consts.BEST_RECORD_INIT, Consts.WINNER_INIT);
    }

    @Test
    @DisplayName("승자는 한 명")
    void givenTheOnlyOneBestRecord_thenGetWinner() {
        car1.move(Consts.INVALID_VALUE + 1);
        this.record.record(1, car1);
        assertThat(record.getWinner()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("승자는 두 명")
    void givenTwoBestRecord_thenGetWinners() {
        car1.move(Consts.INVALID_VALUE + 1);
        this.record.record(1, car1);

        car2.move(Consts.INVALID_VALUE + 1);
        this.record.record(1, car2);

        assertThat(record.getWinner()).isEqualTo("pobi, crong");
    }

    @Test
    @DisplayName("모두가 승자")
    void givenAllBestRecord_thenGetWinners() {
        car1.move(Consts.INVALID_VALUE + 1);
        this.record.record(1, car1);

        car2.move(Consts.INVALID_VALUE + 1);
        this.record.record(1, car2);

        car3.move(Consts.INVALID_VALUE + 1);
        this.record.record(1, car3);

        assertThat(record.getWinner()).isEqualTo("pobi, crong, honux");
    }

    @Test
    @DisplayName("승자는 없음")
    void givenNothingBestRecord_thenGetWinners() {
        car1.move(Consts.INVALID_VALUE);
        this.record.record(1, car1);

        car2.move(Consts.INVALID_VALUE);
        this.record.record(1, car2);

        car3.move(Consts.INVALID_VALUE);
        this.record.record(1, car3);

        assertThat(record.getWinner()).isEmpty();
    }

}