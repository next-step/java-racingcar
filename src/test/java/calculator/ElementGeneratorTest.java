package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ElementGeneratorTest {

    private ElementGenerator elementGenerator;

    @Test
    void 입력값이_Null일_때_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator(null));
    }

    @Test
    void 입력값이_공백일_때_에러() {
        String EMPTY_INPUT = "";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator(EMPTY_INPUT));
    }

    @Test
    void 입력값에_사칙연산이_아닌_값이_있을_때_에러() {
        String INCORRECT_INPUT = "12 $ 34 / 5";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new ElementGenerator(INCORRECT_INPUT));
    }

    @Test
    void 정상() {
        String CORRECT_INPUT = "12 * 3 / 2";
        elementGenerator = new ElementGenerator(CORRECT_INPUT);
        List<String> elements = elementGenerator.getElements();

        for (int i = 0; i < elements.size(); i++) {
            if (i % 2 == 1) {
                assertThat(elements.get(i)).isIn(Arrays.asList("+", "-", "*", "/"));
            }
        }
    }
}