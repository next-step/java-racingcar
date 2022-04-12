package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("0 또는 자연수 값을 가지는 PositiveInteger 클래스 테스트")
public class PositiveIntegerTest {

    @Test
    @DisplayName("0미만의 값을 생성하면 예외가 발생한다.")
    void negativeValueTest() {
        assertThatThrownBy(() -> new PositiveInteger(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
