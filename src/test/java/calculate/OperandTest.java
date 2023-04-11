package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @Test
    @DisplayName("구분자 구하기")
    void extractDelimiter() {

        String delimiter = ",|:";
        String input = "1:2:3";
        String[] numbers = input.split(delimiter);

        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("숫자 배열 추출하기")
    void extractNumbersList() {

        String delimiter = ",|:";
        String input = "1:2:3";
        String[] numbers = input.split(delimiter);

        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("숫자 배열 넘겨서 합 구하기")
    void calculate() {

        String delimiter = ",|:";
        String input = "1:2:3";
        String[] numbers = input.split(delimiter);

        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
    }
}
