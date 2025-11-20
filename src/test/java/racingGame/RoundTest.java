package racingGame;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {
    @Test
    @DisplayName("positions 리스트가 '-' 문자열 리스트로 변환된다")
    void drawLines_returnsDashLines() {
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
    @DisplayName("positions() 는 생성 시 전달한 위치 리스트를 그대로 반환한다")
    void positions_returnsOriginalList() {
        List<Integer> positions = Arrays.asList(1, 2, 3);
        Round round = new Round(positions);

        assertThat(round.positions()).containsExactly(1, 2, 3);
    }
}
