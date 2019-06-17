package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarHandlerTest {
    @Test
    void 숫자가_4이상인_경우에만_true_반환() {
        Assertions.assertThat(CarHandler.isMoveCondition(0)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(1)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(2)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(3)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(4)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(5)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(6)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(7)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(8)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(9)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(10)).isTrue();
    }

    @Test
    void 숫자가_최소_최대값을_벗어나면_오류() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarHandler.isMoveCondition(CarHandler.MIN_RANDOM_INTEGER - 1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarHandler.isMoveCondition(CarHandler.MAX_RANDOM_INTEGER + 1));
    }
}
