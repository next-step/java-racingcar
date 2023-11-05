import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

@DisplayName("Set 자료형 관련 테스트")
public class SetTest {
    private Set<Integer> numbers = new HashSet<>();

    @BeforeEach
    void setUp() {
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 크기를 확인한다.")
    @Test
    void checkSetSize() { Assertions.assertThat(numbers).hasSize(3); }

    @DisplayName("Set의 요소를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void checkSetValue(int input) {
        Assertions.assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("입력된 값이 Set 변수에 존재하는지 존재하지 않는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void checkSetValue(int input, boolean expected) {
        Assertions.assertThat(numbers).contains(input);
    }
}