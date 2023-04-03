import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("사이즈 정상 테스트")
    void sizeTest() {
        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains 정상 파라미터화 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsParameterizedTest(int input) {
        // then
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("contains 결과 지정 파라미터화 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsParameterizedCsvSourceTest(String input, String expected) {
        // then
        assertThat(numbers.contains(Integer.parseInt(input)))
            .isEqualTo(Boolean.parseBoolean(expected));
    }
}
