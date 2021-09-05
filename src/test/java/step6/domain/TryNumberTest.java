package step6.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TryNumberTest {
    @DisplayName("try number 차감 확인 테스트")
    @Test
    void tryNumberMinusTest() {
        TryNumber actual = new TryNumber(3);
        actual.minus();
        assertThat(actual).isEqualTo(new TryNumber(2));
    }
}