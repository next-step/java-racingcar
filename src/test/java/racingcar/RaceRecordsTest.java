package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RaceRecord;
import racingcar.domain.RaceRecords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceRecordsTest {

    @Test
    @DisplayName("마지막 RaceRecord에서 우승자를 구하는지 확인")
    public void get_winner() {
        Map<String, Integer> map = new HashMap<>();
        map.put("car1", 0);
        map.put("car2", 1);
        map.put("car3", 2);
        RaceRecord lastRaceRecord = new RaceRecord(2, map);
        RaceRecords raceRecords = new RaceRecords();
        raceRecords.getRaceRecords().add(lastRaceRecord);

        List<String> winner = raceRecords.getWinner();
        assertAll(() -> assertEquals(winner.get(0), "car3"),
                () -> assertEquals(winner.size(), 1));
    }
}
