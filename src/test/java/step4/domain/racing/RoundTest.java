package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private final int ROUND_COUNT = 1;

    @DisplayName("Round 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        Round round = new Round(ROUND_COUNT);

        // then
        assertThat(round).isNotNull();

    }
}