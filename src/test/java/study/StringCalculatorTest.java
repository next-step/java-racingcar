package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private String input;
    private String[] resultInput;

    @BeforeEach
    void setUp() {
        input = "2 + 3 * 4 / 2";
        resultInput = input.split(" ");
    }

    @Test
    void inputTest() {
        assertThat(resultInput).hasSize(7);
//        assertThat(resultInput).contains("5");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Integer.parseInt("/");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1"})
    void inputBlankTest(String input) {
        assertThat(input).isBlank();
    }

    @ParameterizedTest
    @ValueSource(strings = {"/"})
    void parsingTest(String input) {
        assertThatThrownBy(() -> {
            Integer.parseInt(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("For input string: \""+input+"\"");
    }

    @Test
    void inputValidator() {
        System.out.println(Integer.parseInt(resultInput[1]));

    }
}
