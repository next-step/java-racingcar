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
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Test
    @DisplayName("Set 의 크기를 가져온다.")
    void getSizeOfUniqueSet() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "{0} 이 Set 에 들어있는지 확인한다.")
    @ValueSource(ints = {1, 2, 3})
    void containsReturnTrueIfInputIsOneToThree(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{0} 이 Set 에 들어있는지 확인한다. 결과는 {1} 여야 한다.")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsReturnTrueAndFalseRespectively(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }
}
