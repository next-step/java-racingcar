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

    @Test
    @DisplayName("set size 테스트")
    void testSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("value source를 이용한 contains() 메소드 반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} value={0}")
    @ValueSource(ints = {1, 2, 3})
    void testContainsByValueSource(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("csv source를 이용한 contains() 메소드 반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} value={0}")
    @CsvSource(value = {"1: true", "2: true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void testContainsByCsvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
