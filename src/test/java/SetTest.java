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

    @Test
    @DisplayName("성공 - 중복이 제거된 Set 크기를 확인할 수 있다.")
    void success_set_size_test() {
        //when
        int size = numbers.size();
        int expected = 3;

        //then
        assertThat(size).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("성공 - Set에 1,2,3 값이 존재 하는지 확인 한다.")
    void success_set_contains_test(int given) {
        //when & then
        assertThat(numbers.contains(given)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("성공 - Set에 1,2,3 값이 존재 하며 4,5는 존재 하지 않는다.")
    void success_set_validate_contains_test(int input, boolean expected) {
        //when & then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
