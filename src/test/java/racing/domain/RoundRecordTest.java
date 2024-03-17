package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundRecordTest {

    @Test
    @DisplayName("게임 기록 저장 하는 메소드")
    void addHistory_test() {
        Car car = new Car("p");
        RoundRecord roundRecord = new RoundRecord();
        roundRecord.addHistory(car);
        Map<String, Integer> positions = roundRecord.getPositions();
        assertEquals(1, positions.size());
        assertEquals(Integer.valueOf(0), positions.values().iterator().next());
    }
}