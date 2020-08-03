package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SnapShotEntryTest {

    @DisplayName("해당 Entry에서 우승자 확인")
    @Test
    public void getWinnersTest() {
        // given
        Entry entry = new Entry(Arrays.asList(
                generateCar("A"),
                generateCar("B"),
                generateCar("C")));
        RacingRule alwaysGoRule = () -> true;
        Record record = new Record();

        // when
        entry.move(alwaysGoRule);
        record.keep(entry);

        // then
        assertThat(record.getFinalRoundSnapShot().getWinners()).
                containsExactly("A","B","C");
    }

    private RacingCar generateCar(String name) {
        return new RacingCar(name);
    }
}
