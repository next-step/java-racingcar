package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinnersTest {

    @Test
    @DisplayName("null 또는 빈 List 입력시 IllegalArgumentException 발생")
    void case_when_winners_are_empty_throws_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Winners.of(new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> Winners.of(null));
    }

    @Test
    @DisplayName("Winners가 빈 List가 아닐 때 정상적으로 생성 완료")
    void case_when_winners_are_not_empty() {
        assertDoesNotThrow(() -> {
            List<String> winners = new ArrayList<>();
            winners.add("bmw");
            winners.add("benz");
            winners.add("audi");
            return Winners.of(winners);
        });
    }
}
