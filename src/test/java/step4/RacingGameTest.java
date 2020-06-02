package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 테스트")
class RacingGameTest {
    private List<String> carNames = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));
    private RacingGame racingGame = new RacingGame(carNames, () -> true);

    @DisplayName("play시 자동차 이동 확인")
    @Test
    void play() {
        racingGame.play();
        assertThat(racingGame.getCars().getCars().get(0).getPosition()).isEqualTo(1);
    }


}
