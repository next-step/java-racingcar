package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStatusTest {
    @DisplayName("3단계 - 자동차 경주 - 자동차 전진 조건 테스트")
    @Test
    void go_condition() {
        int randomNumber = 4;
        assertThat(MoveStatus.findByNumber(randomNumber)).isEqualTo(MoveStatus.GO);
    }

}
