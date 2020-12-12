package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountTest {
    @Test
    @DisplayName("횟수 생성")
    void createCount() {
        Count count = new Count(5);
        assertThat(count.getCount()).isEqualTo(5);

    }

    @Test
    @DisplayName("횟수 유효성 검증")
    void validCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Count(0);
        })
                .withMessageContaining("주어진 횟수는 최소 1번입니다.");
    }
}
