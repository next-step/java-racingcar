package calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class StringAddCalculatorTest {
    @Test
    public void NULL입력_0반환하기() {
        // Given
        String inputText = null;

        // When
        int result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 빈문자열입력_0반환하기() {
        // Given
        String inputText = "";

        // When
        int result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 숫자문자열_쉼표_구분자로_구분하기() {
        // Given
        String inputText = "1,2,3";

        // When
        List<Integer> result = StringAddCalculator.split(inputText);

        // Then
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    public void 숫자문자열_콜론_구분자로_구분하기() {
        // Given
        String inputText = "1:2:3";

        // When
        List<Integer> result = StringAddCalculator.split(inputText);

        // Then
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    public void 숫자문자열_쉼표_또는_콜론_구분자로_구분하기() {
        // Given
        String inputText = "1:2,3";

        // When
        List<Integer> result = StringAddCalculator.split(inputText);

        // Then
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    public void 입력값_모두더하기() {
        // Given
        String inputText = "1,2,3,4,5";

        // When
        int result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 커스텀구분자로_구분하기() {
        // Given
        String inputText = "//;\n1;2;3";

        // When
        List<Integer> numbers = StringAddCalculator.split(inputText);

        // Then
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    public void 커스텀구분자_포함된_입력값_모두더하기() {
        // Given
        String inputText = "//;\n1;2;3";

        // When
        int result = StringAddCalculator.calc(inputText);

        // Then
        assertThat(result).isEqualTo(6);
    }
}
