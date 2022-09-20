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

    @DisplayName("numbers의 크기인 3을 반환해야 한다.")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("numbers의 요소를 포함하고 있어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @DisplayName("numbers의 요소를 포함하고 있으면 true, 포함하고 있지 않다면 false를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false"
    })
    void contains2(int data, boolean expected) {
        assertThat(numbers.contains(data)).isEqualTo(expected);
    }

}
