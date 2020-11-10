package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class WinStrategyImplTest {
    @Test
    @DisplayName("우승자 선출 테스트")
    public void decideWinners() {
        int roundNum = 1;
        RoundRecords roundRecords = new RoundRecords(roundNum);
        LinkedHashMap<String, Integer> record = new LinkedHashMap<>();
        int maxPosition = 2;
        record.put("pobi", maxPosition);
        record.put("crong", maxPosition);
        record.put("honux", Car.INITIAL_POSITION);
        roundRecords.addRecord(new RoundRecord(record));

        Winners winners = new WinStrategyImpl().decideWinners(roundRecords);

        assertThat(winners.getNames()).containsExactly("pobi", "crong");
        assertThat(winners.getPosition()).isEqualTo(maxPosition);
    }
}
