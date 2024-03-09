import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jeongheekim
 * @date 3/6/24
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

    @Test
    @DisplayName("numbers의 size는 3이다.")
    void setSizeTest() {
        assertEquals(numbers.size(), 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("원소들이 set에 존재한다.")
    void elementsExistInSetTest(int input) {
        assertThat(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("set에 존재하지 않는 contains 검사 시 false를 리턴한다.")
    void elementsNotExistReturnFailTest(int input, boolean expected) {
        assertEquals(numbers.contains(input),expected);
    }
}
