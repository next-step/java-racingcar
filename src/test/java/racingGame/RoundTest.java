package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("positions 리스트가 각 자동차의 '-' 출력으로 변환된다")
    void drawLines_returnsCorrectDashLines() {
        List<Integer> positions = Arrays.asList(0, 1, 3);
        Round round = new Round(positions);

        List<String> lines = round.drawLines();

        assertThat(lines).containsExactly(
            "",
            "-",
            "---"
        );
    }

    @Test
    @DisplayName("positions() 는 외부에서 변경할 수 없는 리스트를 반환한다")
    void positions_isUnmodifiable() {
        List<Integer> positions = Arrays.asList(1, 2, 3);
        Round round = new Round(positions);

        List<Integer> result = round.positions();

        assertThatThrownBy(() -> result.add(99))
            .isInstanceOf(UnsupportedOperationException.class);
    }
}
