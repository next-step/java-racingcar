package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @DisplayName("Arguments check / Null or Empty")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void inputCheckByEmpty(String input) {

        StringCalculator stringCalculator = new StringCalculator(input);

        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    //stringCalculator.inputCheck();
                    InputCheck.emptyCheck(stringCalculator.getInput(), stringCalculator.getSEPARATOR());

                }
        );
    }

    @DisplayName("Arguments check / Null")
    @ParameterizedTest
    @NullAndEmptySource
    void inputCheckByNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    StringCalculator stringCalculator = new StringCalculator(input);

                    stringCalculator.inputCheck();
                    InputCheck.emptyCheck(stringCalculator.getInput(), stringCalculator.getSEPARATOR());
                }
        );
    }

    @DisplayName("Arguments check / Less Expression")
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "1 +", "4 *", "*", "/", "- 23424", "555 -", "999", "9 /", "1 1",
            "2233 3434", "6 *", "* 54", "45 54", "23123 3432423 34", "1 2 3"})
    void lessExpression(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    stringCalculator.inputCheck();
                    InputCheck.minimumExpressionCheck(stringCalculator.getInputArray());
                }
        );
    }


    @DisplayName("Arguments check / Number Position & Operator Position")
    @ParameterizedTest
    @ValueSource(strings = {"1 1 * 1", "0 0 + 134 +", "1 + 1 123", "4 * + 1", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5"})
    void positionCheck(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    stringCalculator.inputCheck();
                    InputCheck.matchingNumbersAndOperators(stringCalculator.getInputArray());
                }
        );
    }


    @DisplayName("Arguments check / Number Position")
    @ParameterizedTest
    @ValueSource(strings = {"1 1 * 1", "0 0 + 134 +", "1 + 1 123", "4 * + 1", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5"})
    void numberStringCheck(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    stringCalculator.inputCheck();
                    InputCheck.numberStringCheck(stringCalculator.getInputArray());
                }
        );
    }

    @DisplayName("Arguments check / Symbol Position")
    @ParameterizedTest
    @ValueSource(strings = {"1 1 * 1", "0 0 + 134 +", "1 + 1 123", "4 * + 1", "+ 1", "1 + 2 3 + 4", "8 * * 3",
            "555 - 22 234", "999 999 - 1", "9 / 4 4", "5 + 2 + 3 + 4 + + 5"})
    void calculateSymbolCheck(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    stringCalculator.inputCheck();
                    InputCheck.numberStringCheck(stringCalculator.getInputArray());
                }
        );
    }


    @DisplayName("Calculte Check")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "2 * 3 + 3:9", "3 * 3 + 2 + 3 / 2:7", "2 + 3 * 4 / 2:10", "500 / 2 / 10 * 2:50"},
            delimiter = ':')
    void calculteCheck(String input, int expeted) {

        StringCalculator stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.calculate()).isEqualTo(expeted);

    }


}
