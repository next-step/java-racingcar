package racingcar.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.backend.dto.CarDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRecordsTest {

    GameRecords gameRecords;
    List<CarDto> gameRecord;

    @BeforeEach
    void setUp() {
        gameRecords = new GameRecords();
        gameRecord = Arrays.asList(
                CarDto.create(new CarName("BB"), new Position(1)),
                CarDto.create(new CarName("CC"), new Position(3)),
                CarDto.create(new CarName("DD"), new Position(3)));
        gameRecords.add(new GameRecord(gameRecord));
    }

    @Test
    @DisplayName("위너는 CC,DD 자동차")
    void find_final_winner() {
        List<CarDto> winner = gameRecords.getWinner();
        assertThat(winner).hasSize(2)
                .extracting(CarDto::printName)
                .contains("CC", "DD");
    }
}
