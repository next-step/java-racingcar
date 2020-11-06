package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WinStrategyImplTest {
    @Test
    @DisplayName("우승자 선출 테스트")
    public void decideWinners() {
        int roundNum = 1;
        RoundRecords roundRecords = new RoundRecords(roundNum);
        LinkedHashMap<String, Integer> record = new LinkedHashMap<>();
        int maxPosition = 2;
        List<String> winnerNames = Arrays.asList("pobi", "crong");
        record.put(winnerNames.get(0), maxPosition);
        record.put(winnerNames.get(1), maxPosition);
        record.put("honux", Car.INITIAL_POSITION);
        roundRecords.addRecord(new RoundRecord(record));

        Winners winners = new WinStrategyImpl().decideWinners(roundRecords);

        assertThat(winners.getNames()).isEqualTo(winnerNames);
        assertThat(winners.getPosition()).isEqualTo(maxPosition);
    }
}
