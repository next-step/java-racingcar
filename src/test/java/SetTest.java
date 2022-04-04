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
    @DisplayName("멤버변수 numbers 의 크기가 3인지를 확인하는 테스트")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
    @ValueSource(ints = {1,2,3})
    void contains(int num) {
        assertThat(numbers).contains(num);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 경우 true, 4, 5의 경우  false")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void notContains(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
