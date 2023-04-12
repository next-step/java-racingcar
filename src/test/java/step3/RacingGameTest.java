package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
                .hasMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
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
                .hasMessageMatching("시도할 횟수는 양수여야 합니다.");
    }

    @DisplayName("경주 진행마다 각자 이름을 가진 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"test", "pobi,crong,honux"})
    public void raceTest(String name) {
        // given
        RacingGame racingGame = new RacingGame();
        racingGame.preparingGame(name, 1);
        List<String> names = Arrays.asList(name.split(","));

        // when
        List<String> result = racingGame.race();

        // then
        assertThat(result).hasSize(names.size());
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).contains(names.get(i) + " : -");
        }
    }

}