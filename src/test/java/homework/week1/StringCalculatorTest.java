package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator emptyInputStringCalculator;
    private StringCalculator whiteSpaceInputStringCalculator;
    private StringCalculator nullInputStringCalculator;
    private StringCalculator stringCalculator;
    private StringCalculator minArrayLengthStringCalculator;
    private StringCalculator evenArrayLengthStringCalculator;
    private StringCalculator invalidLastValueStringCalculator;
    private StringCalculator invalidFirstValueStringCalculator;
    private StringCalculator invalidNumberValueStringCalculator;
    private StringCalculator invalidOperationalSymbolValueStringCalculator;
    private StringCalculator operationStringCalculator;


    @BeforeEach
    void setUp() {
        System.out.println("StringCalculator Test setUp");
        emptyInputStringCalculator = new StringCalculator("");
        whiteSpaceInputStringCalculator = new StringCalculator(" ");
        nullInputStringCalculator = new StringCalculator(null);
        stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        minArrayLengthStringCalculator = new StringCalculator("2 +");
        minArrayLengthStringCalculator.splitInputString();
        evenArrayLengthStringCalculator= new StringCalculator("2 + 3 *");
        evenArrayLengthStringCalculator.splitInputString();
        invalidLastValueStringCalculator = new StringCalculator("2 + +");
        invalidLastValueStringCalculator.splitInputString();
        invalidFirstValueStringCalculator = new StringCalculator("+ + 2");
        invalidFirstValueStringCalculator.splitInputString();
        invalidNumberValueStringCalculator = new StringCalculator("? + 2 * /");
        invalidNumberValueStringCalculator.splitInputString();
        invalidOperationalSymbolValueStringCalculator = new StringCalculator("2 3 2 + 4");
        invalidOperationalSymbolValueStringCalculator.splitInputString();
        operationStringCalculator = new StringCalculator("2 + 3 * 4 / 2");
    }

    @Test
    void validateInputString() {
        System.out.println("validateInputString");
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
        stringCalculator.splitInputString();
        assertThat(stringCalculator.elementStringArray.length).isEqualTo(7);
    }

    @Test
    void validateElementStringArrayLength() {
        System.out.println("validateElementStringArrayLength");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            minArrayLengthStringCalculator.validateElementStringArrayLength();
            evenArrayLengthStringCalculator.validateElementStringArrayLength();
            stringCalculator.splitInputString();
            stringCalculator.validateElementStringArrayLength();
        });
    }

    @Test
    void validateElementStringArrayFirstValueAndLastValue() {
        System.out.println("validateElementStringArrayFirstValueAndLastValue");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidLastValueStringCalculator.validateElementStringArrayFirstValueAndLastValue();
            invalidFirstValueStringCalculator.validateElementStringArrayFirstValueAndLastValue();
            stringCalculator.splitInputString();
            stringCalculator.validateElementStringArrayLength();
        });
    }

    @Test
    void setNumberStringElementList() {
        System.out.println("setNumberStringElementList");
        stringCalculator.splitInputString();
        stringCalculator.setNumberStringElementList();
        assertThat(stringCalculator.numberStringElementList.size()).isEqualTo(4);

    }

    @Test
    void setOperationalSymbolElementList() {
        System.out.println("setOperationalSymbolElementList");
        stringCalculator.splitInputString();
        stringCalculator.setOperationalSymbolElementList();
        assertThat(stringCalculator.operationalSymbolElementList.size()).isEqualTo(3);
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
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidNumberValueStringCalculator.setNumberStringElementList();
            invalidNumberValueStringCalculator.validateNumberStringElementListValues();
            stringCalculator.splitInputString();
            stringCalculator.setNumberStringElementList();
            stringCalculator.validateNumberStringElementListValues();
        });

    }

    @Test
    void validateOperationalSymbolElementListValues() {
        System.out.println("validateOperationalSymbolStringValue");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            invalidOperationalSymbolValueStringCalculator.setOperationalSymbolElementList();
            invalidOperationalSymbolValueStringCalculator.validateOperationalSymbolElementListValues();
            stringCalculator.splitInputString();
            stringCalculator.setOperationalSymbolElementList();
            stringCalculator.validateOperationalSymbolElementListValues();
        });
    }

    @Test
    void setNumberElementList() {
        System.out.println("setNumberElementList");
        stringCalculator.splitInputString();
        stringCalculator.setNumberStringElementList();
        stringCalculator.setNumberElementList();
        assertThat(stringCalculator.numberElementList.size()).isEqualTo(stringCalculator.numberStringElementList.size());
    }

    @Test
    void plus() {
        System.out.println("plus");
        operationStringCalculator.result = 1;
        operationStringCalculator.plus(3, StringCalculator.PLUS_SYMBOL);
        operationStringCalculator.plus(3, StringCalculator.MINUS_SYMBOL);
        assertThat(operationStringCalculator.result).isEqualTo(4);
    }

    @Test
    void minus() {
        System.out.println("minus");
        operationStringCalculator.result = 1;
        operationStringCalculator.minus(3, StringCalculator.MINUS_SYMBOL);
        operationStringCalculator.minus(3, StringCalculator.PLUS_SYMBOL);
        assertThat(operationStringCalculator.result).isEqualTo(-2);
    }

    @Test
    void multiply() {
        System.out.println("multiply");
        operationStringCalculator.result = 1;
        operationStringCalculator.multiply(3, StringCalculator.MULTIPLY_SYMBOL);
        operationStringCalculator.multiply(3, StringCalculator.MINUS_SYMBOL);
        assertThat(operationStringCalculator.result).isEqualTo(3);
    }

    @Test
    void division() {
        System.out.println("division");
        operationStringCalculator.result = 3;
        operationStringCalculator.division(3, StringCalculator.DIVISION_SYMBOL);
        operationStringCalculator.division(3, StringCalculator.MINUS_SYMBOL);
        assertThat(operationStringCalculator.result).isEqualTo(1);
    }

    @Test
    void calculate() {
        System.out.println("calculate");
        stringCalculator.prepareForCalculate(stringCalculator);
        stringCalculator.calculate();
        assertThat(stringCalculator.result).isEqualTo(10);
    }
}
