package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingOptionsTest {

    @Test
    @DisplayName("레이싱 옵션은 양수로만 입력이 가능합니다.")
    void test1() {
        assertThatNoException().isThrownBy(() -> new RacingOptions(3, 5));
    }

    @Test
    @DisplayName("레이싱 옵션에 0 또는 음수 입력시 예외가 발생합니다.")
    void test2() {
        assertThatThrownBy(() -> new RacingOptions(-1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}