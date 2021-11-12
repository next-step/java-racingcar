package study03.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RoundResultTest {

    @Test
    @DisplayName("자동차 디폴트 위치 확인")
    void 위치확인() {
        RoundResult roundResult = new RoundResult(new Cars(5));
        for (Integer result : roundResult.getResult()) {
            assertThat(result).isEqualTo(0);
        }

    }
}