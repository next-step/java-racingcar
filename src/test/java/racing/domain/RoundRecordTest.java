package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundRecordTest {

    @Test
    void add_test() {
        RoundRecord roundRecord = new RoundRecord();
        roundRecord.add(1);
        roundRecord.add(2);
        roundRecord.add(3);
        List<Integer> positions = roundRecord.getPositions();
        assertEquals(3, positions.size());
        assertEquals(Integer.valueOf(1), positions.get(0));
    }
}