package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기를 확인한다")
    @Test
    void checkSize() {

        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("1,2,3의 값이 존재하는지 확인한다")
    @Test
    void checkIfContains() {

        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("중복코드를 제거하여 값이 존재하는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkWithParameterizedTest(int values) {

        assertThat(numbers.contains(values)).isTrue();
    }

    @DisplayName("입력 값에따라 결과가 달라지도록 구성한다")
    @ParameterizedTest
    @CsvSource(value = {"true, false"})
    void checkWhetherContainsOrNot(Boolean right, Boolean wrong){

        assertThat(numbers.contains(1)).isEqualTo(right);
        assertThat(numbers.contains(4)).isEqualTo(wrong);
    }

}
