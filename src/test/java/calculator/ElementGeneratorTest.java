package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ElementGeneratorTest {

    @Test
    void 입력값이_Null일_때_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator(null));
    }

    @Test
    void 입력값이_Empty일_때_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator(""));
    }

    @Test
    void 입력값이_Blank일_때_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator("       "));
    }

    @Test
    void 입력값에_사칙연산이_아닌_값이_있을_때_에러() {
        String INCORRECT_INPUT = "12 $ 34 / 5";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator(INCORRECT_INPUT));
    }
}
