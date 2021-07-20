package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("자동차 수와 반복횟수를 매개변수로 게임 생성")
    void create() {
        Game game = new Game(3, 5);
        assertThat(game.getCarSize()).isEqualTo(3);
        assertThat(game.getRepeatCount()).isEqualTo(5);
    }

    @ParameterizedTest(name = "{displayName} [{index}]")
    @CsvSource(value = {"3:0", "3:-1", "0:5", "-1:5"}, delimiter = ':')
    @DisplayName("자동차 수와 반복횟수는 0 혹은 음수가 될 수 없다.")
    void valid(int carSize, int repeatSize) {
        assertThatThrownBy(() -> new Game(carSize, repeatSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 실행")
    void run() {
        Game game1 = new Game(3, 5);
        assertThat(game1.runOnce(new int[]{4, 4, 4})).isTrue();
        assertThat(game1.getCarsStatus()).containsExactly(1, 1, 1);

        Game game2 = new Game(4, 5);
        assertThat(game2.runOnce(new int[]{4, 3, 6, 3})).isTrue();
        assertThat(game2.getCarsStatus()).containsExactly(1, 0, 1, 0);
    }
}
