package study;

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

    @Test
    @DisplayName("set size를 확인한다.")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "element가 포함되어있는지 확인한다. - expected element: {arguments}")
    @ValueSource(ints = {1, 2, 3})
    void contains1(int expectedElement) {
        assertThat(numbers.contains(expectedElement)).isTrue();
    }

    @ParameterizedTest(name = "element가 포함되어있는지 확인한다. - expected element and result: {arguments}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int element, boolean expectedResult) {
        assertThat(numbers.contains(element)).isEqualTo(expectedResult);
    }
}
