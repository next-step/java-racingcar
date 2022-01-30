package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    public void 숫자를_넣는건_정상동작() {
        //given
        Numbers numbers = Numbers.get();

        //when
        String input = "333";

        //then
        assertThatCode(() -> numbers.addNumber(input)).doesNotThrowAnyException();
    }

    @Test
    public void 숫자이외의_값이_들어가면_예외발생() {
        //given
        Numbers numbers = Numbers.get();

        //when
        String input = "jason";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            numbers.addNumber(input);
        });
    }
}