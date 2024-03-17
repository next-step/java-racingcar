package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundRecordsTest {

    @Test
    @DisplayName("우승자 한명인 경우")
    void 우승자_한명() {

        Car A = Car.withName("A");
        A.forward(() -> true);

        Car B = Car.withName("B");
        B.forward(() -> false);

        RoundRecord roundRecord = new RoundRecord(Map.of(
                A.getName(), A.getPosition(),
                B.getName(), B.getPosition()));

        RoundRecords roundRecords = new RoundRecords(List.of(roundRecord));
        assertThat(roundRecords.findWinner()).contains("A");
    }

    @Test
    @DisplayName("복수의 우승자")
    void 우승자_다수() {

        Car A = Car.withName("A");
        A.forward(() -> true);

        Car B = Car.withName("B");
        B.forward(() -> true);

        RoundRecord roundRecord = new RoundRecord(Map.of(
                A.getName(), A.getPosition(),
                B.getName(), B.getPosition()));

        RoundRecords roundRecords = new RoundRecords(List.of(roundRecord));
        assertThat(roundRecords.findWinner()).contains("A", "B");
    }
}
