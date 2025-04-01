import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("[요구사항1] Set의 size() 메소드를 활용해 numbers의 크기가 3인 것을 확인한다")
    @Test
    void successSetSize() {
        int expected = numbers.size();

        assertThat(numbers).hasSize(expected);
    }

    @DisplayName("[요구사항2] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void successSetContains(int input) {
        assertThat(numbers).contains(input);
    }

    @DisplayName("[요구사항3] 입력 값에 따라 set에 포함 여부 결과 값이 다른지 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkSetInclusionByInput(int actual, boolean expected) {
        assertThat(numbers.contains(actual)).isEqualTo(expected);
    }
}
