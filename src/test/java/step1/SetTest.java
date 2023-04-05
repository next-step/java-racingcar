package step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : 0giri
 * @since : 2023/04/05
 */
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

    @DisplayName("Set의 크기(Element 개수)를 확인한다")
    @Test
    void size_ShouldReturnSetsElementsCount() {
        //given
        //when
        int result = numbers.size();
        //then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Set의 Element 중 해당 값이 존재하는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ShouldReturnSetHasValueSource(int value) {
        //given
        //when
        boolean result = numbers.contains(value);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("입력값에 따라")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_ShouldReturnSetHasCsvSource(int value, boolean expected) {
        //given
        //when
        boolean result = numbers.contains(value);
        //then
        assertThat(result).isEqualTo(expected);
    }

}
