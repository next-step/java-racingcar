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

    @DisplayName("Set은 중복된 데이터를 허용하지 않는다.")
    @Test
    void Set_does_not_allow_duplicate_data() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set의 contains() 메서드는 인자로 Set에 포함된 데이터가 들어오면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_should_return_1_or_2_or_3(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains() 메서드는 인자로 Set에 포함된 데이터가 들어오면 true를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_should_return_true_for_contain_value(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
