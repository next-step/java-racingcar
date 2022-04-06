package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ZeroTest {

    @Test
    @DisplayName("0을 입력하면 객체를 생성한다")
    void createZeroNumber() {
        //when, then
        Number zero = new Zero(0);
        assertThat(zero).isEqualTo(new Zero(0));
    }

    @Test
    @DisplayName("0를 입력하지 않으면 예외를 발생시킨다")
    void testExceptionWhenNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Zero(-2));
    }

}