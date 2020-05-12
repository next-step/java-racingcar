package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("Arguments check / Null or Empty")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void inputCheckByEmpty(String input) {
        InputCheck inputCheck = new InputCheck(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    inputCheck.emptyCheck(inputCheck.input);
                }
        );
    }

    @DisplayName("Arguments check / Null")
    @Test
    @NullAndEmptySource
    void inputCheckByNull(String input) {
        InputCheck inputCheck = new InputCheck(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    inputCheck.emptyCheck(inputCheck.input);
                }
        );
    }


    @DisplayName("Arguments check / Less Expression")
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "1 +", "4 *", "*", "/", "- 23424", "555 -", "999", "9 /", "1 1",
            "2233 3434", "6 *", "* 54", "45 54", "23123 3432423 34", "1 2 3"})
    void lessExpression(String input) {
        InputCheck inputCheck = new InputCheck(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    inputCheck.minimumExpressionCheck(inputCheck.inputArray);
                }
        );
    }


    @DisplayName("Arguments check / Number Position & Operator Position")
    @ParameterizedTest
    @ValueSource(strings = {"1 1 * 1", "0 0 + 134 +", "1 + 1 123", "4 * + 1", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5"})
    void positionCheck(String input) {
        InputCheck inputCheck = new InputCheck(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    inputCheck.matchingNumbersAndOperators(inputCheck.inputArray);
                }
        );
    }


    @DisplayName("Arguments check / Number Position")
    @ParameterizedTest
    @ValueSource(strings = {"1 1 * 1", "0 0 + 134 +", "1 + 1 123", "4 * + 1", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5"})
    void numberStringCheck(String input) {
        InputCheck inputCheck = new InputCheck(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    inputCheck.numberStringCheck(inputCheck.inputArray);
                }
        );
    }

    @DisplayName("Arguments check / Symbol Position")
    @ParameterizedTest
    @ValueSource(strings = {"1 1 * 1", "0 0 + 134 +", "1 + 1 123", "4 * + 1", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5"})
    void calculateSymbolCheck(String input) {
        InputCheck inputCheck = new InputCheck(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    inputCheck.calculateSymbolCheck(inputCheck.inputArray);
                }
        );
    }


    @DisplayName("Calculte Check")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "2 * 3 + 3:9", "3 * 3 + 2 + 3 / 2:7", "2 + 3 * 4 / 2:10", "500 / 2 / 10 * 2:50"},
            delimiter = ':')
    void calculteCheck(String input, int expeted) {
        InputCheck inputCheck = new InputCheck(input);
        StringCalculator stringCalculator = new StringCalculator(inputCheck);
        assertThat(stringCalculator.calculate()).isEqualTo(expeted);
    }


}