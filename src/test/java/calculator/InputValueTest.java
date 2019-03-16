package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValueTest {
    @Test
    public void 입력받기_구분자() {
        String input = "1,2,3";
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.getDelimiterWord()).isEqualTo(",|:");
    }

    @Test
    public void 입력받기_별도_구분자() {
        String input = "//;\n1;2;3";
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.getDelimiterWord()).isEqualTo(";");
    }

    @Test
    public void 입력받기_별도_구분자2() {
        String input = "//?\n1?2?3";
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.getDelimiterWord()).isEqualTo("?");
    }

    @Test
    public void 입력받기_수식() {
        String input = "1,2,3";
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.getFormula()).isEqualTo("1,2,3");
    }

    @Test
    public void 입력받기_수식2() {
        String input = "3,4,5";
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.getFormula()).isEqualTo("3,4,5");
    }

    @Test
    public void 입력받기_수식_별도_구분자() {
        String input = "//;\n1;2;3";
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.getFormula()).isEqualTo("1;2;3");
    }
}
