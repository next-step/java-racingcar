package study;

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

    @DisplayName("size() 메소드를 통해 Set의 크기를 확인할 수 있다.")
    @Test
    void size() {
        //GIVEN
        //WHEN
        int size = numbers.size();

        //THEN
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "contains() 메소드를 통해 {index} 값은 존재하는 것을 확인할 수 있다.")
    @ValueSource(ints = {1, 2, 3})
    void contains1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "contains() 메소드를 통해 {0} 값에 대한 결과는 {1} 인 것을 확인할 수 있다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
