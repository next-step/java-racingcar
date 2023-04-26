package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.PlayCount;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayCountTest {

    @Test
    @DisplayName("게임 횟수 0체크")
    void validatePlayCountEmptyThrows() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayCount(0))
                .withMessageMatching("게임 횟수는 0일 수 없습니다.");
    }

    @Test
    void validatePlayCountNegativeNumberThrows() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayCount(-1))
                .withMessageMatching("게임 횟수는 음수일 수 없습니다.");
    }
}
