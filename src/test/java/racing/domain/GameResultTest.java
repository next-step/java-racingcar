package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.move.RandomMove;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    @DisplayName("게임 결과 - 라운드별 결과 추가")
    void 라운드목록_라운드별_기록추가() {
        assertThat(Arrays.asList(new Round(), new Round()).size()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 결과 - 우승자 출력")
    void 우승자_조회() {
        Game game = new Game(new GameSet.GameSetBuilder(
                new RandomMove(), Arrays.asList("car1", "car2"), 3).build());

        game.start();

        assertThat(game.getGameResult().gameWinner()).startsWith("car");
    }
}
