package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberFactoryTest {

    @Test
    @DisplayName("정상적인 객체 생성을 확인한다")
    void fromTest() {
        //when
        Number number1 = NumberFactory.from(0);
        Number number2 = NumberFactory.from(1);

        //then
        assertThat(number1).isEqualTo(new Zero());
        assertThat(number2).isEqualTo(new PositiveNumber(1));
    }

    @Test
    @DisplayName("음수 입력 시 예외를 발생시킨다")
    void fromExceptionTest() {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> NumberFactory.from(-1));
    }

}
