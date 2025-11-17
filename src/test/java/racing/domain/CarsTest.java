package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 경주할_자동차의_개수가_1일_때_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 경주를 진행하기 위해서는 두 대 이상의 자동차가 필요합니다.");
    }
}
