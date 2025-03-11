import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인할 수 있다.")
    @Test
    void getSize_UsingSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set에 저장한 데이터의 존재 여부를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void confirm_IsExist(int testNumber) {
        assertThat(numbers).contains(testNumber);
    }

    @DisplayName("Set에 저장된 데이터는 true를, 저장되지 않은 데이터는 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "1, true",
        "2, true",
        "3, true",
        "4, false",
        "5, false"
    })
    void contains_returnsTrueOrFalse_ByInput(int inputNumber, boolean expected) {
        assertThat(numbers.contains(inputNumber)).isEqualTo(expected);
    }
}
