package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameCountTest {

    @Test
    @DisplayName("0 이상의 양의 정수 입력 시 정상적으로 객체가 생성됩니다.")
    void test01() {
        assertThatNoException().isThrownBy(() -> new GameCount(1));
    }

    @Test
    @DisplayName("0 또는 음의 정수 입력 시 예외가 발생합니다.")
    void test02() {
        assertAll(
                () -> assertThatThrownBy(() -> new GameCount(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new GameCount(-1)).isInstanceOf(IllegalArgumentException.class)
        );
    }

}