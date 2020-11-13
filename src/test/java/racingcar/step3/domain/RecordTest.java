package racingcar.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-10 오후 12:51.
 * Developer : Seo.
 */
class RecordTest {

    @Test
    @DisplayName("최고 기록 확인")
    void getBestTest() {
        Race race = new Race("pobi,crong,honux");
        Record record = race.run(5);
        assertThat(record.getWinner()).isNotEmpty();
        assertThat(record.getBest()).isBetween(0, 5);
    }

}