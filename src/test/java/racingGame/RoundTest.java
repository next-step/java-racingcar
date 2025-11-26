package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("입력된 위치 리스트가 그대로 Round에 저장된다")
    void roundStoresPositionsCorrectly() {
        List<Integer> positions = Arrays.asList(1, 3, 5);

        Round round = new Round(positions);

        assertThat(round.positions())
            .containsExactly(1, 3, 5);
    }

    @Test
    @DisplayName("Round 내부 리스트는 불변이어야 한다 (외부에서 변경 불가)")
    void roundIsImmutable() {
        List<Integer> positions = Arrays.asList(1, 2);
        Round round = new Round(positions);

        assertThatThrownBy(() -> round.positions().add(99))
            .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("여러 Round가 각각 독립적으로 저장된다")
    void multipleRoundsAreIndependent() {
        Round round1 = new Round(Arrays.asList(1, 2, 3));
        Round round2 = new Round(Arrays.asList(3, 2, 1));

        assertThat(round1.positions()).containsExactly(1, 2, 3);
        assertThat(round2.positions()).containsExactly(3, 2, 1);

        assertThat(round1.positions()).isNotEqualTo(round2.positions());
    }

    @Test
    @DisplayName("음수 위치가 포함되면 예외가 발생한다 (도메인 제약)")
    void negativePositionThrowsException() {
        List<Integer> invalid = Arrays.asList(1, -1, 3);

        assertThatThrownBy(() -> new Round(invalid))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("positions()는 깊은 복사된 값을 반환해야 한다 (외부 리스트 변경 영향 없음)")
    void returnsDefensiveCopy() {
        List<Integer> positions = Arrays.asList(1, 2, 3);
        Round round = new Round(positions);

        List<Integer> result = round.positions();

        assertThatThrownBy(() -> result.add(10))
            .isInstanceOf(UnsupportedOperationException.class);

        assertThat(round.positions()).containsExactly(1, 2, 3);
    }
}
