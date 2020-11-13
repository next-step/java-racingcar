package racingcar.step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.domain.Race;
import racingcar.step3.domain.Record;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-02 오후 12:41.
 * Developer : Seo.
 */
class RaceTest {

    @Test
    @DisplayName("기록 확인")
    void run() {
        Race race = new Race("pobi,crong,honux");
        Record record = race.run(5);
        assertThat(record.getWinner()).isNotEmpty();
        assertThat(record.getBest()).isBetween(0,5);
        assertThat(record.getTotalRecords()).hasSize(5);
    }

}