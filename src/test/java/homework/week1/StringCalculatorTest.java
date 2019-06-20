package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;
    private StringCalculator operationStringCalculator;

    @BeforeEach
    void setUp() {
        System.out.println("StringCalculator Test setUp");
        stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        operationStringCalculator = new StringCalculator("2 + 3 * 4 / 2");
    }

    @Test
    void validateInputString() {
        System.out.println("validateInputString");
        StringCalculator emptyInputStringCalculator = new StringCalculator("");
        StringCalculator whiteSpaceInputStringCalculator = new StringCalculator(" ");
        StringCalculator nullInputStringCalculator = new StringCalculator(null);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            emptyInputStringCalculator.validateInputString();
            whiteSpaceInputStringCalculator.validateInputString();
            nullInputStringCalculator.validateInputString();
            stringCalculator.validateInputString();
        });
    }

    @Test
    void splitInputString() {
        System.out.println("splitInputString");
        assertThat(stringCalculator.splitInputString().length).isEqualTo(7);
    }

    @Test
    void validateElementStringArrayLength() {
        System.out.println("validateElementStringArrayLength");
        StringCalculator minArrayLengthStringCalculator = new StringCalculator("2 +");
        StringCalculator evenArrayLengthStringCalculator= new StringCalculator("2 + 3 *");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            minArrayLengthStringCalculator.validateElementStringArrayLength(minArrayLengthStringCalculator.splitInputString());
            evenArrayLengthStringCalculator.validateElementStringArrayLength(evenArrayLengthStringCalculator.splitInputString());
            stringCalculator.validateElementStringArrayLength(stringCalculator.splitInputString());
        });
    }

    @Test
    void validateElementStringArrayFirstValueAndLastValue() {
        System.out.println("validateElementStringArrayFirstValueAndLastValue");
        StringCalculator invalidLastValueStringCalculator = new StringCalculator("2 + +");
        StringCalculator invalidFirstValueStringCalculator = new StringCalculator("+ + 2");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidLastValueStringCalculator.validateElementStringArrayFirstValueAndLastValue(invalidLastValueStringCalculator.splitInputString());
            invalidFirstValueStringCalculator.validateElementStringArrayFirstValueAndLastValue(invalidFirstValueStringCalculator.splitInputString());
            stringCalculator.validateElementStringArrayLength(stringCalculator.splitInputString());
        });
    }

    @Test
    void setNumberStringElementList() {
        System.out.println("setNumberStringElementList");
        List<String> numberStringElements = stringCalculator.getNumberStringElementList(stringCalculator.splitInputString());
        assertThat(numberStringElements.size()).isEqualTo(4);

    }

    @Test
    void setOperationalSymbolElementList() {
        System.out.println("setOperationalSymbolElementList");
        stringCalculator.setOperationalSymbolElementList(stringCalculator.splitInputString());
        assertThat(stringCalculator.getOperationalSymbolElementList().size()).isEqualTo(3);
    }

    @Test
    void validateNumberStringValue() {
        System.out.println("validateNumberStringValue");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.validateNumberStringValue("344/");
        });
    }

    @Test
    void validateOperationalSymbolStringValue() {
        System.out.println("validateOperationalSymbolStringValue");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.validateOperationalSymbolStringValue("?234");
        });
    }

    @Test
    void validateNumberStringElementListValues() {
        System.out.println("validateNumberStringValue");
        StringCalculator invalidNumberValueStringCalculator = new StringCalculator("? + 2 * /");
        invalidNumberValueStringCalculator.splitInputString();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> numberStringElements1 = invalidNumberValueStringCalculator.getNumberStringElementList(invalidNumberValueStringCalculator.splitInputString());
            invalidNumberValueStringCalculator.validateNumberStringElementListValues(numberStringElements1);
            List<String> numberStringElements2 = stringCalculator.getNumberStringElementList(stringCalculator.splitInputString());
            stringCalculator.validateNumberStringElementListValues(numberStringElements2);
        });

    }

    @Test
    void validateOperationalSymbolElementListValues() {
        System.out.println("validateOperationalSymbolStringValue");
        StringCalculator invalidOperationalSymbolValueStringCalculator = new StringCalculator("2 3 2 + 4");
        invalidOperationalSymbolValueStringCalculator.splitInputString();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidOperationalSymbolValueStringCalculator.setOperationalSymbolElementList(invalidOperationalSymbolValueStringCalculator.splitInputString());
            invalidOperationalSymbolValueStringCalculator.validateOperationalSymbolElementListValues();
            stringCalculator.setOperationalSymbolElementList(stringCalculator.splitInputString());
            stringCalculator.validateOperationalSymbolElementListValues();
        });
    }

    @Test
    void setNumberElementList() {
        System.out.println("setNumberElementList");
        List<String> numberStringElements = stringCalculator.getNumberStringElementList(stringCalculator.splitInputString());
        stringCalculator.setNumberElementList(numberStringElements);
        assertThat(stringCalculator.getNumberElementList().size()).isEqualTo(numberStringElements.size());
    }

    @Test
    void plus() {
        System.out.println("plus");
        int result = 1;
        result = operationStringCalculator.plus(result,3, StringCalculator.PLUS_SYMBOL);
        result = operationStringCalculator.plus(result,3, StringCalculator.MINUS_SYMBOL);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void minus() {
        System.out.println("minus");
        int result = 1;
        result = operationStringCalculator.minus(result, 3, StringCalculator.MINUS_SYMBOL);
        result = operationStringCalculator.minus(result, 3, StringCalculator.PLUS_SYMBOL);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    void multiply() {
        System.out.println("multiply");
        int result = 1;
        result = operationStringCalculator.multiply(result, 3, StringCalculator.MULTIPLY_SYMBOL);
        result = operationStringCalculator.multiply(result, 3, StringCalculator.MINUS_SYMBOL);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void division() {
        System.out.println("division");
        int result = 3;
        result = operationStringCalculator.division(result, 3, StringCalculator.DIVISION_SYMBOL);
        result = operationStringCalculator.division(result, 3, StringCalculator.MINUS_SYMBOL);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void calculate() {
        System.out.println("calculate");
        stringCalculator.prepareForCalculate(stringCalculator);
        assertThat(stringCalculator.calculate()).isEqualTo(10);
    }
}
