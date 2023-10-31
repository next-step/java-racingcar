package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("@ParameterizedTest를 활용해 중복 코드를 제거한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void validContains(Integer number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("@CscSource를 활용해 실패하는 테스트 케이스를 구현한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void validNotContains(Integer number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
