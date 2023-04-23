package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RepsTest {

    @Test
    @DisplayName("Reps 생성 테스트")
    void Reps_생성_테스트() {
        int given = 4;

        Reps result = new Reps(given);

        assertThat(result.getReps()).isEqualTo(given);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("0보다 작은 숫자일 때 예외를 던진다")
    void _0보다_작은_숫자일_때_예외를_던진다(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Reps(input))
                .withMessage("0보다 큰 수를 입력해주세요.");
    }

    @Test
    @DisplayName("Reps 차감 테스트")
    void Reps_차감_테스트() {
        Reps result = new Reps(5);

        result.repsDown();

        assertThat(result.getReps()).usingRecursiveComparison()
                .isEqualTo(4);
    }

    @Test
    @DisplayName("isOverZero 메서드는 진행할 수 있는 경우 true를 반환한다")
    void 진행할_Reps가_존재할떄_테스트() {
        Reps result = new Reps(5);
        assertThat(result.isOverZero()).isTrue();
    }

    @Test
    @DisplayName("isOverZero 메서드는 진행할 수 있는 경우 false를 반환한다")
    void 진행할_Reps가_없을때_테스트() {
        Reps result = new Reps(1);
        result.repsDown();
        assertThat(result.isOverZero()).isFalse();
    }
}