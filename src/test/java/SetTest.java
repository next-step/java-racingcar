import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("Set 타입 인스턴스 numbers 의 사이즈를 확인")
    @Test
    void checkNumbersSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("특정 값이 주어졌을때, Set 타입 인스턴스 numbers 가 가지고 있는지에 대한 검증")
    @ParameterizedTest(name = "numbers 에 들어있는지 확인하는 값: {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains(int expected) {
        assertThat(numbers.contains(expected)).isTrue();
    }

    @DisplayName("특정 값이 주어졌을때, Set 타입 인스턴스 numbers 가 가지고 있는지에 대한 결과값을 검증")
    @ParameterizedTest(name = "numbers 에 들어있는지 확인하는 값: {0}, 예상되는 결과값: {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}


