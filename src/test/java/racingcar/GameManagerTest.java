package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    @Test
    @DisplayName("게임 한 라운드 플레이 모든 car 전진")
    void play_everyCarOneMovement() {
        int carNum = 2;
        int movement = 1;
        int gameRoundNum = 3;
        GameManager gameManager = new GameManager(() -> movement);

        Records records = gameManager.play(carNum, gameRoundNum);

        assertThat(records.getRecordList()).hasSize(gameRoundNum);
        IntStream.range(0, gameRoundNum).forEach(idx -> {
            int round = idx + 1;
            List<Integer> positions = records.getRecordList().get(idx).getPositions();
            assertThat(positions).hasSize(carNum);
            positions.forEach(position -> assertThat(position).isEqualTo((round) * movement));
        });
    }
}
