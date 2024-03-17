package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundRecordsTest {

    @Test
    void 우승자_한명() {
        RoundRecord roundRecord = new RoundRecord();

        Car A = Car.withName("A");
        A.forward(() -> true);
        roundRecord.addHistory(A);

        Car B = Car.withName("B");
        B.forward(() -> false);
        roundRecord.addHistory(B);

        RoundRecords roundRecords = new RoundRecords(List.of(roundRecord));
        assertThat(roundRecords.findWinner()).contains("A");
    }

    @Test
    void 우승자_다수() {
        RoundRecord roundRecord = new RoundRecord();

        Car A = Car.withName("A");
        A.forward(() -> true);
        roundRecord.addHistory(A);

        Car B = Car.withName("B");
        B.forward(() -> true);
        roundRecord.addHistory(B);

        RoundRecords roundRecords = new RoundRecords(List.of(roundRecord));
        assertThat(roundRecords.findWinner()).contains("A", "B");
    }
}
