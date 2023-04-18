package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameRoundTest {

    @Test
    @DisplayName("maxRound 는 0 이상의 양의 정수만 입력가능합니다.")
    void test01() {
        assertThatNoException().isThrownBy(() -> new GameRound(1));
    }

    @Test
    @DisplayName("maxRound 는 0 또는 음의 정수를 입력할 수 없습니다.")
    void test02() {
        assertAll(
                () -> assertThatThrownBy(() -> new GameRound(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new GameRound(-1)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("nextRound 는 1회만 증가합니다.")
    void test03() {
        GameRound gameRound = new GameRound(1);
        gameRound.nextRound();
        assertThat(gameRound.isDone()).isTrue();
    }

    @Test
    @DisplayName("nextRound 는 maxRound 만큼만 수행가능힙니다.")
    void test04() {
        GameRound gameRound = new GameRound(1);
        assertAll(
                () -> assertThatNoException().isThrownBy(gameRound::nextRound),
                () -> assertThatThrownBy(gameRound::nextRound).isInstanceOf(IllegalStateException.class)
        );
    }

}