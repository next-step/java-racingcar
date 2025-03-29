import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    @DisplayName("레이싱 게임 생성 테스트")
    void generateTest() {
        String name = "honux, pobi, brown";
        String[] splitName = name.split(",");
        RacingGame racingGame = new RacingGame(splitName);
        assertThat(racingGame.cars.cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("글자 초과로 인한 생성 실패 테스트")
    void splitTest() {
        String name = "honux,pobi,brownn";
        String[] splitName = name.split(",");
        assertThatThrownBy(
            () -> new RacingGame(splitName)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
