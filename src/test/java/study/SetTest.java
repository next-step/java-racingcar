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

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드로 Set 의 크기를 확인한다.")
    @Test
    void setSizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("Set의 Contains() 메소드를 활용해 1,2,3 의 값이 존재하는지 확인한다.")
    @Test
    void setContainsTest() {
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @DisplayName("Set의 Contains() 메소드를 ParameterizedTest 를 통해 1,2,3 의 값이 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContainsParameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("CsvSource 를 활용해 값의 존재 여부를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true","4,false", "5,false"}, delimiter = ',')
    void setContainsParameterizedTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
