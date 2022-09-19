package step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("주어진_Set의_크기가_3인지_테스트")
    @Test
    void req1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("주어진_Set_안에_존재하는_숫자가_확인_테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void req2(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("주어진_Set_안에_숫자가_있는지_테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void req3(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }

}
