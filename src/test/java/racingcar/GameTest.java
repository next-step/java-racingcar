package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("올바른 자동차 대수와 시도횟수를 입력받는다.")
    void test1() {
        int carAmount = 3;
        int tryAmount = 5;
        Game game = new Game(carAmount, tryAmount);
        assertThat(game.getCarAmount()).isEqualTo(3);
        assertThat(game.getTryAmount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("올바르지 않은 자동차 대수를 입력한다.")
    void test2(int carAmount) {
        int tryAmount = 5;
        assertThatThrownBy(() -> new Game(carAmount, tryAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수는 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("올바르지 않은 시도 횟수를 입력한다.")
    void test3(int tryAmount) {
        int carAmount = 3;
        assertThatThrownBy(() -> new Game(carAmount, tryAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}
