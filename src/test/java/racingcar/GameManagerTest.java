package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

public class GameManagerTest {

    @Test
    @DisplayName("게임 한 라운드 플레이 모든 car 전진")
    void play_everyCarOneMovement() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        int movement = 1;
        int gameRoundNum = 2;
        GameManager gameManager = new GameManager(() -> movement);

        RoundRecords roundRecords = gameManager.play(names, gameRoundNum);

        IntStream.range(0, gameRoundNum).forEach(idx -> {
            int round = idx + 1;
            Map<String, Integer> record = roundRecords.getRoundRecordList().get(idx).getRecord();
            assertThat(record).containsExactly(
                    entry("pobi", round * movement),
                    entry("crong", round * movement),
                    entry("honux", round * movement));
        });
    }
}
