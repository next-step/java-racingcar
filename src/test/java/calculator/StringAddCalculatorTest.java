package calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    public void NULL입력_0반환하기() {
        // Given
        String inputText = null;

        // When
        Positive result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void 빈문자열입력_0반환하기() {
        // Given
        String inputText = "";

        // When
        Positive result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void 숫자하나입력_숫자하나반환하기() {
        // Given
        String inputText = "1";

        // When
        Positive result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(new Positive(1));
    }

    @Test
    public void 숫자문자열_쉼표_구분자로_구분하기() {
        // Given
        String inputText = "1,2,3";

        // When
        List<Positive> result = StringAddCalculator.split(inputText);

        // Then
        assertThat(result)
                .isEqualTo(Arrays.asList(
                        new Positive(1),
                        new Positive(2),
                        new Positive(3)));
    }

    @Test
    public void 숫자문자열_콜론_구분자로_구분하기() {
        // Given
        String inputText = "1:2:3";

        // When
        List<Positive> result = StringAddCalculator.split(inputText);

        // Then
        assertThat(result)
                .isEqualTo(Arrays.asList(
                        new Positive(1),
                        new Positive(2),
                        new Positive(3)));
    }

    @Test
    public void 숫자문자열_쉼표_또는_콜론_구분자로_구분하기() {
        // Given
        String inputText = "1:2,3";

        // When
        List<Positive> result = StringAddCalculator.split(inputText);

        // Then
        assertThat(result)
                .isEqualTo(Arrays.asList(
                        new Positive(1),
                        new Positive(2),
                        new Positive(3)));
    }

    @Test
    public void 입력값_모두더하기() {
        // Given
        String inputText = "1,2,3,4,5";

        // When
        Positive result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(new Positive(15));
    }

    @Test
    public void 커스텀구분자로_구분하기() {
        // Given
        String inputText = "//;\n1;2;3";

        // When
        List<Positive> result = StringAddCalculator.split(inputText);

        // Then
        // Then
        assertThat(result)
                .isEqualTo(Arrays.asList(
                        new Positive(1),
                        new Positive(2),
                        new Positive(3)));
    }

    @Test
    public void 커스텀구분자_포함된_입력값_모두더하기() {
        // Given
        String inputText = "//;\n1;2;3";

        // When
        Positive result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test(expected = RuntimeException.class)
    public void 입력값에_숫자아닌값이_포함된_경우() {
        String inputText = "1:r:3";

        StringAddCalculator.calc(inputText);
    }

    @Test(expected = RuntimeException.class)
    public void 입력값에_음수가_포함된_경우() {
        String inputText = "1:-1:3";

        Positive result = StringAddCalculator.calc(inputText);
    }
}
