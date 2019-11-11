package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("게임 결과 생성확인")
    void createGameResult() {
        List<Records> records = new ArrayList<>();
        records.add(new Records(Arrays.asList(
                new CarRecord("a", 1),
                new CarRecord("b", 1))));
        records.add(new Records(Arrays.asList(
                new CarRecord("a", 1),
                new CarRecord("b", 2))));

        GameResult gameResult = new GameResult(records);

        assertThat(gameResult.getRecords()).hasSize(2);
        assertThat(gameResult.findWinners()).containsExactly("b");
    }
}
