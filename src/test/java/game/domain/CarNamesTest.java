package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarNamesTest {

    @Test
    @DisplayName("콤마를 구분자로 사용한 입력의 경우 정상수행됩니다.")
    void test01() {
        assertAll(
                () -> assertThatNoException().isThrownBy(() -> CarNames.of("A")),
                () -> assertThatNoException().isThrownBy(() -> CarNames.of("A,B,C"))
        );
    }

    @Test
    @DisplayName("입력이 없을 경우 에러가 발생합니다.")
    void test02() {
        assertAll(
                () -> assertThatThrownBy(() -> CarNames.of(null))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> CarNames.of(""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> CarNames.of(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
}