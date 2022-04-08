package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositiveNumberTest {

    @Test
    @DisplayName("양수를 입력하면 객체를 생성한다")
    void createPositiveNumber() {
        //when, then
        PositiveNumber two = new PositiveNumber(2);
        assertThat(two).isEqualTo(new PositiveNumber(2));
    }

    @Test
    @DisplayName("양수를 입력하지 않으면 예외를 발생시킨다")
    void testExceptionWhenNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new PositiveNumber(-2));
    }

}
