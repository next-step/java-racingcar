import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAdderTest {
    @DisplayName(", 또는 : 구분자를 기준으로 분리된 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = { "''=0", "=0", "1,2=3", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void add(String numbers, int sumOfNumbers) {
        StringAdder adder = new StringAdder(numbers);
        
        assertThat(adder.calc()).isEqualTo(sumOfNumbers);
    }

    @DisplayName(", 또는 : 구분자를 기준으로 분리된 숫자 중에서 음수가 있다면 RuntimeException 을 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = { "-1,2", "1,-2,3", "1,2:-3" })
    void add_when_negative_number(String numbers) {
        StringAdder adder = new StringAdder(numbers);
        
        assertThatThrownBy(() -> adder.calc()).isInstanceOf(RuntimeException.class);
    }
}
