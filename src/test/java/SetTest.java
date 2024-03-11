import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set 학습테스트")

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
    @DisplayName("Set의 크기를 반환한다")
    public void getSizeOfSetTest() {
        assertThat(numbers.size()).isEqualTo(4);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에 값이 존재한다")
    public void containsTrueTest(int num) {
        assertThat(numbers.contains(num)).isEqualTo(true);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, true",
            "3, true",
            "4, false",
    }, delimiter = ',')
    @DisplayName("Set에 값이 존재한다")
    public void containsTrueFalseTest(String fixture, String expect) {
        assertThat(numbers.contains(Integer.parseInt(fixture)))
                .isEqualTo(Boolean.parseBoolean(expect));
    }


}
