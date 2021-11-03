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

    @DisplayName("요구1: Set의 크기 확인")
    @Test
    void checkSize() {
        // given
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("요구2: Set에 이미 존재하는 원소의 포함 여부 검사")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void checkIfContainsAddedElements(int element) {
        // given
        // when
        boolean contains = numbers.contains(element);

        // then
        assertThat(contains).isTrue();
    }

    @DisplayName("요구3: Set에 특정 원소의 포함 여부 검사")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    void checkIfContainsElements(int element, boolean expectedResult) {
        // given
        // when
        boolean contains = numbers.contains(element);

        // then
        assertThat(contains).isEqualTo(expectedResult);
    }
}
