package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JudgementTest {

    @Test
    @DisplayName("4 이상이면 true, 아니면 false")
    void isNumberGreaterThanFour() {
        assertThat(Judgement.isNumberGreaterThanFour(4)).isTrue();
        assertThat(Judgement.isNumberGreaterThanFour(3)).isFalse();
    }

}