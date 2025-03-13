package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @NullAndEmptySource
    @DisplayName("null 또는 빈문자를 입력할 경우 0을 반환해야 한다.")
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(new Input(input));
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(new Input(input));
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ValueSource(strings = {"1", "2", "3"})
    public void splitAndSum_숫자하나(String input) throws Exception {
        int result = StringAddCalculator.splitAndSum(new Input(input));
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @DisplayName("숫자 두 개를 콤마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ValueSource(strings = {"1,2", "1,2,"})
    public void splitAndSum_쉼표구분자(String input) throws Exception {
        int result = StringAddCalculator.splitAndSum(new Input(input));
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자는 콤마(,)와 콜론(:)을 사용할 수 있다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum(new Input("1,2:3"));
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("구분자는 //와 /n 문자를 이용해 커스텀 구분자를 지정할 수 있다.")
    @ValueSource(strings = {";", ":"})
    public void splitAndSum_custom_구분자(String delimiter) throws Exception {
        List<String> inputNumbers = List.of("1", "2", "3");
        String customDelimiter = "//" + delimiter + "\n";

        int result = StringAddCalculator.splitAndSum(new Input(customDelimiter + String.join(delimiter, inputNumbers)));
        assertThat(result).isEqualTo(
                inputNumbers.stream()
                .mapToInt(Integer::parseInt)
                .sum()
        );
    }

    @ParameterizedTest
    @DisplayName("음수를 전달할 경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "1,-2,3"})
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(new Input(input)))
                .isInstanceOf(RuntimeException.class);
    }
}
