package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
    @Test
    @DisplayName("PositiveNumber에 문자 또는 숫자를 넣어도 같은 결과를 내는데 성공")
    void 객체_생성() {
        assertThat(new PositiveNumber("1")).isEqualTo(new PositiveNumber(1));
    }

    @Test
    @DisplayName("PositiveNumber로 생성된 값에 다른 양수값을 더해 성공")
    void 덧셈() {
        PositiveNumber positiveNumber = new PositiveNumber("1");
        PositiveNumber result = positiveNumber.plus(new PositiveNumber(2));
        assertThat(result).isEqualTo(new PositiveNumber(3));
    }

    @Test
    @DisplayName("음수를 넣었을 때 익셉션이 발생해서 실패")
    void 음수() {
        assertThatThrownBy(() -> {
            new PositiveNumber("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
