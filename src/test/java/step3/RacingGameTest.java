package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    public void nameCheckTest() {
        assertThatThrownBy(() -> {
            String given = "테스트용자동차이름";
            RacingGame racingGame = new RacingGame();
            racingGame.preparingGame(given, 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("시도 횟수는 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void nameCheckTest(int count) {
        assertThatThrownBy(() -> {
            String given = "자동차이름";
            RacingGame racingGame = new RacingGame();
            racingGame.preparingGame(given, count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 양수여야 합니다.");
    }

}