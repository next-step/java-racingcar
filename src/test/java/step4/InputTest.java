package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @DisplayName("자동차 이름에 대한 입력값 테스트")
    @Test
    void inputTest() {
        assertThatThrownBy(() -> {
            Validator.checkCarName("NEXT-STEP");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 초과하였습니다.");
    }

    @DisplayName("시도 횟수에 대한 입력값 테스트")
    @Test
    void tryCountTest() {
        assertThatThrownBy(() -> {
            Validator.checkTryCountIsMinus(-2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수가 잘못되었습니다.");
    }
}
