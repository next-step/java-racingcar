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
    @DisplayName("요구사항1 - Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void testSetSize() {
        var expected = 3;
        var actual = numbers.size();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("요구사항2 - Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    @ValueSource(ints = {1, 2, 3} )
    @ParameterizedTest
    void testSetContainsSuccess(int number) {
        var expected = true;
        var actual = numbers.contains(number);

        assertThat(actual).isEqualTo(expected);
    }

    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항3 - Set의 contains() 메소드를 활용, 성공과 실패 여부 확인")
    @ParameterizedTest
    void testSetContainsFailure(int number, boolean expected) {
        var actual = numbers.contains(number);

        assertThat(actual).isEqualTo(expected);
    }
}
