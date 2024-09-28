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

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    @Test
    void countSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set에 특정 값이 포함되어 있는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})  // 테스트할 값들 제공
    void contains(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("Set에 특정 값이 포함되어 있는지 여부를 확인한다")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void containsEachElement(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
