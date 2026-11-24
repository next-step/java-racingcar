package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundResultTest {

    @DisplayName("위치 목록으로 생성하면 그 위치들을 알 수 있다. ([1, 2, 3] → [1, 2, 3])")
    @Test
    void test_1() {
        assertThat(new RoundResult(List.of(1, 2, 3)).getPositions()).containsExactly(1, 2, 3);
    }

    @DisplayName("위치가 같으면 같은 기록이다. ([1, 2] == [1, 2])")
    @Test
    void test_4() {
        assertThat(new RoundResult(List.of(1, 2))).isEqualTo(new RoundResult(List.of(1, 2)));
    }
}
