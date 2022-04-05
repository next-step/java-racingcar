package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @Test
    @DisplayName("양수를 입력하면 객체를 생성한다")
    void createPositiveNumber() {
        //when, then
        Number two = new Number(2);
        assertThat(two).isEqualTo(new Number(2));
    }

    @Test
    @DisplayName("0을 입력하면 객체를 생성한다")
    void createZeroNumber() {
        //when, then
        Number zero = new Number(0);
        assertThat(zero).isEqualTo(new Number(0));
    }

    @Test
    @DisplayName("음수를 입력하면 예외를 발생시킨다")
    void testExceptionWhenNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(-2));
    }

}
