package racingcar.domain.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {

    @Test
    @DisplayName("TryNumber 유효성 테스트")
    void invalidTest() {
        assertThatThrownBy(() -> new TryNumber(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new TryNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("isNotZero 기능 테스트")
    void isNotZeroTest() {
        TryNumber tryNumber = new TryNumber(2);

        tryNumber.decrease();
        assertThat(tryNumber.isNotZero()).isTrue();

        tryNumber.decrease();
        assertThat(tryNumber.isNotZero()).isFalse();

    }
}