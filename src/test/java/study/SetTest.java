package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

    Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("HashSet의 size()는 3이 반환된다.")
    void testHashSetSize() {

        // when
        int actualSize = numbers.size();

        // then
        assertThat(actualSize).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("HashSet에 특정 값이 포함되어 있는지 확인한다.")
    void testHashSetContains(int number) {

        // when & then
        assertThat(numbers.contains(number)).isTrue();
    }

    @RepeatedTest(5)
    @DisplayName("HashSet은 순서가 보장되지 않아서 실행할 때 마다 순서가 다를 수 있다.")
    void testHashSetOrderChanges() {

        // when
        Integer[] array = numbers.toArray(new Integer[0]);

        // then
        assertThat(array).containsExactlyInAnyOrder(1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false",
    })
    @DisplayName("HashSet의 contains()를 통해 값의 포함 여부를 반환한다.")
    void testToString(int number, boolean expected) {

        // when
        boolean expectedResult = numbers.contains(number);

        // then
        assertThat(expectedResult).isEqualTo(expected);
    }
}
