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
    @DisplayName("게임 플레이 모든 car 한 칸 전진 확인")
    void play_everyCarOneMovement() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        int movement = 1;
        int gameRoundNum = 2;
        GameManager gameManager = new GameManager(() -> movement, new WinStrategyImpl());

        GameResult gameResult = gameManager.play(names, gameRoundNum);

        IntStream.range(0, gameRoundNum).forEach(idx -> {
            int round = idx + 1;
            Map<String, Integer> record = gameResult.getRoundRecords().getRoundRecordList().get(idx).getRecord();
            assertThat(record).containsExactly(
                    entry("pobi", round * movement),
                    entry("crong", round * movement),
                    entry("honux", round * movement));
        });
    }

    @Test
    @DisplayName("게임 플레이 우승자 확인")
    void play_verifyWinner() {
        int gameRoundNum = 2;
        GameManager gameManager = new GameManager(new RuleStrategyImpl(),
                (roundRecords) -> new Winners(Arrays.asList("pobi", "crong"), Car.INITIAL_POSITION));

        GameResult gameResult = gameManager.play(Arrays.asList("pobi", "crong", "honux"), gameRoundNum);

        assertThat(gameResult.getWinnerNames()).containsExactly("pobi", "crong");
    }
}
