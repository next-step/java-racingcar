package training;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetCollectionTest {
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
    void 요구사항_1() {
        // given
        int expected = 3;

        // when
        int actual = numbers.size();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3}) // given
    void 요구사항_2(int element) {
        // when
        boolean actual = numbers.contains(element);

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false"}, delimiter = ':') // given
    void 요구사항_3(int element, boolean expected) {
        // when
        boolean actual = numbers.contains(element);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
