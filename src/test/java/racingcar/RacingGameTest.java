package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("시도 횟수만큼 기록이 저장되는지 확인")
    public void play_test() {
        List<String> carNames = new ArrayList();
        carNames.add("car1");
        carNames.add("car2");
        RacingGame racingGame = new RacingGame(carNames, 5);
        racingGame.play();
        assertThat(racingGame.getRaceRecords().size()).isEqualTo(5);
    }
}
