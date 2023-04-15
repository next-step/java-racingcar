package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    @Test
    @DisplayName("Position 의 경우 0 이상의 숫자로 초기화가 가능합니다.")
    void test01() {
        assertAll(
                () -> assertThatNoException()
                        .isThrownBy(Position::new),
                () -> assertThatNoException()
                        .isThrownBy(() -> new Position(0)),
                () -> assertThatNoException()
                        .isThrownBy(() -> new Position(5))
        );
    }

    @Test
    @DisplayName("Position 의 경우 0 미만의 숫자로 초기화시 에러가 발생합니다.")
    void test02() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}