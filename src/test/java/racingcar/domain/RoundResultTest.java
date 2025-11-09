package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RoundResultTest {

    @Test
    void null_위치_정보로_생성_시_예외발생() {
        assertThatThrownBy(() -> new RoundResult(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치 정보는 null일 수 없습니다.");
    }

    @Test
    void 빈_위치_정보로_생성_시_예외발생() {
        assertThatThrownBy(() -> new RoundResult(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치 정보는 비어있을 수 없습니다.");
    }
}
