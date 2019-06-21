package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    private static final int TEST_ROUND = 3;

    @Test
    void 라운드를_생성한다() {
        Round round = Round.from(TEST_ROUND);
        assertThat(round.getRound()).isEqualTo(TEST_ROUND);
    }
}
