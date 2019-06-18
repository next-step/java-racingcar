package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarHandlerTest {
    @Test
    void 숫자가_4이상인_경우에만_true_반환() {
        assertThat(CarHandler.isMoveCondition(0)).isFalse();
        assertThat(CarHandler.isMoveCondition(3)).isFalse();
        assertThat(CarHandler.isMoveCondition(4)).isTrue();
        assertThat(CarHandler.isMoveCondition(10)).isTrue();
    }

    @Test
    void 숫자가_최소_최대값을_벗어나면_오류() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarHandler.isMoveCondition(CarHandler.MIN_RANDOM_INTEGER - 1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarHandler.isMoveCondition(CarHandler.MAX_RANDOM_INTEGER + 1));
    }
}
