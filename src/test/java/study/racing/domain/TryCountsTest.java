package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TryCountsTest {

    @Test
    @DisplayName("정상적인 수를 입력할 경우 시도 횟수를 생성한다.")
    void createTryCountsTest() {
        // given
        String input = "2";

        // when
        TryCounts tryCounts = new TryCounts(input);

        // then
        assertThat(tryCounts).isEqualTo(new TryCounts("2"));
    }

    @Test
    @DisplayName("숫자를 입력 하지 않은 경우 예외를 발생시킨다.")
    void errorWhenInputNotInt() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> new TryCounts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("시도할 횟수가 0 이하일 경우 예외가 발생한다.")
    void errorWhenTryCountsUnderOne() {
        // given
        String input = "0";

        // when & then
        assertThatThrownBy(() -> new TryCounts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수는 1 이상 이어야 합니다.");
    }
}
