package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalTest {

    Calculator cal = new Calculator();

    @Test
    void plus(){
        String input = "1 + 2 + 5";

        int result = cal.calculator(input);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void minu(){
        String input = "5 - 2 - 2";

        int result = cal.calculator(input);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void mul(){
        String input = "2 * 2 * 5";

        int result = cal.calculator(input);

        assertThat(result).isEqualTo(20);
    }

    @Test
    void div(){
        String input = "6 / 2";

        int result = cal.calculator(input);

        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    @DisplayName("Null 체크")
    void nullCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            {
                cal.calculator(input);
            }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "1 ^ 2", "2 ^ 2", "2 % 2" })
    @DisplayName("사칙연산 기호가 아닌 경우")
    void arithmeticOperationsCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    cal.calculator(input);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "0", "1 +", "4 *", "*", "/", "- 23424", "555 -", "999", "9 /", "1 1",
            "2233 3434", "6 *", "* 54", "45 54", "23123 3432423 34", "1 2 3", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5" })
    @DisplayName("잘못된 입력값 체크")
    void badInputCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    cal.calculator(input);
                }
        );
    }

}
