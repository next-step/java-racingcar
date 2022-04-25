package study.step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameCountTest {

    @DisplayName("게임 라운드 입력은 1 이상이어야 한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void gameCount(int count) {
        GameCount gameCount = new GameCount(count);

        assertThat(gameCount).isEqualTo(new GameCount(count));
    }

    @DisplayName("게임 라운드 입력이 0 이하면 excpetion 이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void gameCountException(int count) {
        assertThatThrownBy(() -> {
            GameCount gameCount = new GameCount(count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("game 횟수는 1 이상이어야 합니다");
    }
}