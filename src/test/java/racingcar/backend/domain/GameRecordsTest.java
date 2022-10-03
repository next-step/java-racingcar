package racingcar.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameRecordsTest {
    GameRecords gameRecords;

    @BeforeEach
    void setUp() {
        gameRecords = new GameRecords();
        GameRecord gameRecord = new GameRecord();
        gameRecord.add(Map.of("AA", 1));
        gameRecord.add(Map.of("BB", 0));
        gameRecord.add(Map.of("CC", 1));
        gameRecords.add(gameRecord);

        gameRecord = new GameRecord();
        gameRecord.add(Map.of("AA", 2));
        gameRecord.add(Map.of("BB", 1));
        gameRecord.add(Map.of("CC", 2));
        gameRecords.add(gameRecord);
    }

    @Test
    @DisplayName("위너는 AA,CC 자동차")
    void find_final_winner() {
        List<String> winners = gameRecords.finalWinner();
        assertThat(winners).contains("AA", "CC");
    }
}
