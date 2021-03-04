package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("요구사항1: Set 의 사이즈는 3이다.")
    @Test
    public void getNumbersSizeTest() {
        int expectedSize = 3;

        assertThat(getSize()).isEqualTo(expectedSize);
    }

    @ParameterizedTest(name = "요구사항2: Set 의 {index}번째 값은 {0}이다.")
    @ValueSource(ints = {1, 2, 3})
    public void true_isContainTest(int input) {
        assertThat(isContain(input)).isTrue();
    }

    @ParameterizedTest(name = "요구사항3: Set 의 {index}번째 값은 {0}이다. => {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void trueOrFalse_isContainTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    private int getSize() {
        return numbers.size();
    }

    private boolean isContain(Object inputValue) {
        return numbers.contains(inputValue);
    }

}
