package racingcar.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameRecordsTest {

    GameRecords gameRecords;

    @BeforeEach
    void setUp() {
        gameRecords = new GameRecords();
        Map<CarName, Position> stage1 = new LinkedHashMap<>();
        stage1.put(new CarName("AA"), new Position(0));
        stage1.put(new CarName("BB"), new Position(0));
        stage1.put(new CarName("CC"), new Position(0));
        stage1.put(new CarName("DD"), new Position(0));
        gameRecords.add(GameRecord.create(stage1));
    }

    @Test
    @DisplayName("위너는 BB,DD 자동차")
    void find_final_winner() {
        List<CarName> winner = gameRecords.finalWinner();
        assertThat(winner).hasSize(2)
                .extracting(CarName::getValue)
                .contains("BB", "DD");
    }
}
