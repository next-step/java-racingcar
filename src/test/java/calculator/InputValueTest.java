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
}
